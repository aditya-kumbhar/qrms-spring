package com.qrms.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Users;

//repository to perform CRUD with Users table
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserName(String user_name);
	
//	 public User createAppUser(UserForm form) {
//	        Long userId = this.getMaxUserId() + 1;
//	        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
//	 
//	        AppUser user = new AppUser(userId, form.getUserName(), //
//	                form.getFirstName(), form.getLastName(), false, //
//	                form.getGender(), form.getEmail(), form.getCountryCode(), //
//	                encrytedPassword);
//	 
//	        USERS_MAP.put(userId, user);
//	        return user;
//	    }
}
