package com.qrms.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.passay.CharacterData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.CustomUserDetails;
import com.qrms.spring.model.PasswordResetToken;
import com.qrms.spring.model.Role;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.PasswordResetTokenRepository;
import com.qrms.spring.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserService,UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Autowired
	private EmailServiceImpl email;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
					
				Optional<Users> optionalUsers = usersRepository.findByUserName(userName);
				optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
				return optionalUsers.map(CustomUserDetails::new).get();
		
	}
	
	@Override
	public Users findByUserName(String username) {
		// TODO Auto-generated method stub
		Optional<Users> optionalUsers = usersRepository.findByUserName(username);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(Users::new).get();
	}
	
	@Override
	public Users findUserByEmail(String email) {
		Optional<Users> optionalUsers =  usersRepository.findByEmail(email);
		
		if(!optionalUsers.isPresent()) {
			return null;
		}
		return optionalUsers.map(Users::new).get();

	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	
	}
	
	public String generatePassayPassword() {
	    PasswordGenerator gen = new PasswordGenerator();
	    CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
	    CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
	    lowerCaseRule.setNumberOfCharacters(2);
	 
	    CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
	    CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
	    upperCaseRule.setNumberOfCharacters(2);
	 
	    CharacterData digitChars = EnglishCharacterData.Digit;
	    CharacterRule digitRule = new CharacterRule(digitChars);
	    digitRule.setNumberOfCharacters(2);
	 
	    CharacterData specialChars = new CharacterData() {
	        public String getErrorCode() {
	            return "Special char password error";
	        }
	 
	        public String getCharacters() {
	            return "!@#$%^&*()_+";
	        }
	    };
	    CharacterRule splCharRule = new CharacterRule(specialChars);
	    splCharRule.setNumberOfCharacters(2);
	 
	    String password = gen.generatePassword(10, splCharRule, lowerCaseRule, upperCaseRule, digitRule);
	    return password;
	}
	
	public boolean isUniqueEmail(String email) {
	
		Users tempUser = findUserByEmail(email);
		if(tempUser!=null) {
			return false;
		}
		return true;
	}

	public void saveUser(Users user) {
		
		String username = user.getFirstName().toLowerCase() + user.getLastName().toLowerCase().charAt(0);
		String tempUsername = username;
		System.out.println(tempUsername);
		int i = 0;
		
		//Check if email is unique
		
		while(true) {
			try {
				Optional<Users> userexists = usersRepository.findByUserName(tempUsername);
				userexists.map(CustomUserDetails::new).get().getUserName();
				i++;
				tempUsername = username + Integer.toString(i);
				
			}
			catch(Exception e) {
				user.setUserName(tempUsername);		
				break;
			}	
		}
		
		String password= generatePassayPassword();
		System.out.println("Username: "+ tempUsername + " Password: "+ password);
		
		
		String body = "Hi "+user.getFirstName()+",\nYour QRMS Account has been successfully created.\n"
				+ "Use the following credentials to login:\n"
				+ "Username: "+tempUsername+"\n"+ "Password: "+password
				+ "\n\nDo not share your credentials with anyone.\n"
				+ "Regards,\nQRMS Team.";
		
		try {
		email.send("qrmsmail@gmail.com", user.getEmail(), "Login Credentials for QRMS", body);
		}catch(Exception e) {
			System.out.println("Error Sending Email: " + e.getMessage());
		}
		user.setPassword(bCryptPasswordEncoder().encode(password));
		user.setActive(1);
		
		usersRepository.save(user);
		
		}

	@Override
	public void createPasswordTokenForUser(Users user, String token) {
		
		PasswordResetToken myToken = new PasswordResetToken(token, user);
	    passwordResetTokenRepository.save(myToken);
	
	}
 
	public String validatePasswordResetToken(String username, String token) {
		
		Optional<PasswordResetToken> optionalPassToken = passwordResetTokenRepository.findByToken(token);
		PasswordResetToken passToken;
		
		//check if token is valid
		if (optionalPassToken.isPresent()) {
			passToken = optionalPassToken.map(PasswordResetToken::new).get();
			
			//check if username is valid
			if(!(passToken.getUser().getUserName().equals(username)))
				return "Invalid Token";
			else {
				
				//check if token has expired
				Calendar cal = Calendar.getInstance();
				if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
					passwordResetTokenRepository.delete(passToken);
					return "Token has Expired";
				}
				
				Users user = passToken.getUser();
				Authentication auth = new UsernamePasswordAuthenticationToken(
						user, null, Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
				
				SecurityContextHolder.getContext().setAuthentication(auth);
				
				//Delete the token since it is now used
				passwordResetTokenRepository.delete(passToken);
				
				//token and username are valid, return null
				return null;
			}
		}
		else
			return "Invalid Token";	//if token String is not valid		
	}

	@Override
	public void savePassword(Users user, String password) {
		user.setPassword(bCryptPasswordEncoder().encode(password));
		usersRepository.save(user);
	}

	@Override
	public ArrayList<Users> findByRole(Set<Role> role) {
		// TODO Auto-generated method stub
		ArrayList<Users> users = usersRepository.findByRoles(role);
		return users;
	}

	
}
