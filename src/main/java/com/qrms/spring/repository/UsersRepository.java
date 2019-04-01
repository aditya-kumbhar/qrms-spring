package com.qrms.spring.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.Role;
import com.qrms.spring.model.Users;

//repository to perform CRUD with Users table
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserName(String user_name);
	Optional<Users> findByEmail(String email);
	ArrayList<Users> findByRoles(Set<Role> roles);

}
