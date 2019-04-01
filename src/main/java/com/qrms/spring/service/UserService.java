package com.qrms.spring.service;
import com.qrms.spring.model.Users;

public interface UserService {

	public void saveUser(Users user);
	public Users findUserByEmail(String email);
	public Users findByUserName(String username);
	public void createPasswordTokenForUser(Users user, String token);
	public String validatePasswordResetToken(String username,String token);
	public void savePassword(Users user, String password);
}
