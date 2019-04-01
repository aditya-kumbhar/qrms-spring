package com.qrms.spring.service;
import java.util.ArrayList;
import java.util.Set;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.Users;

public interface UserService {

	public void saveUser(Users user);
	public Users findUserByEmail(String email);
	public Users findByUserName(String username);
	public void createPasswordTokenForUser(Users user, String token);
	public String validatePasswordResetToken(String username,String token);
	public void savePassword(Users user, String password);
	public ArrayList<Users> findByRole(Set<Role> role);
}
