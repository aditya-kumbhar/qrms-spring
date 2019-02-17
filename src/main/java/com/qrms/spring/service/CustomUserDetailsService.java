package com.qrms.spring.service;

import java.util.Optional;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.passay.CharacterData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qrms.spring.model.CustomUserDetails;
import com.qrms.spring.model.Users;
import com.qrms.spring.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserService,UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private EmailServiceImpl email;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

				Optional<Users> optionalUsers = usersRepository.findByUserName(userName);
				optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
				return optionalUsers.map(CustomUserDetails::new).get();
		
//		return usersRepository.findByUserName(userName);
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

	public void saveUser(Users user) {
		
		String username = user.getFirstName().toLowerCase() + user.getLastName().toLowerCase().charAt(0);
		String tempUsername = username;
		System.out.println(tempUsername);
		int i = 0;
		
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
	
 
}
