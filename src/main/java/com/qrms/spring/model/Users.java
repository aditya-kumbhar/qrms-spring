package com.qrms.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class Users {
	
	public Users(Users user) {
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.roles = user.getRoles();
		this.active = user.getActive();
		this.password = user.getPassword();
	}
	
	public Users() {
		
	}
	
	public Users(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="active")
	private int active;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="password")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_name"))
	private Set<Role> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user_id) {
		this.userName = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	//Causes errors
//	@OneToMany(mappedBy = "resourceIncharge", cascade = CascadeType.ALL)
//	Set<Resource> resources = new HashSet<Resource>();
//	
//	
//	@OneToOne(mappedBy = "userDets", cascade = CascadeType.ALL)
//	StudentAcad student = new StudentAcad();
//	
//	@OneToOne(mappedBy = "userDets", cascade = CascadeType.ALL)
//	FacultyAcad faculty = new FacultyAcad();
//	
}
