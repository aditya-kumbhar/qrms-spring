package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.Users;

//repository to perform CRUD with Users table
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserName(String user_name);
	Optional<Users> findByEmail(String email);
	ArrayList<Users> findByRoles(Set<Role> roles);
	
	@Query("select new Users(u.userName, u.firstName, u.lastName) from Users u where u.userName in ?1")
	List<Users> findByUserNameList(List<String> facIds);
	

}
