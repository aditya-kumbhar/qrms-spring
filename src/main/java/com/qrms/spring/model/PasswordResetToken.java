package com.qrms.spring.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PasswordResetToken {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public PasswordResetToken(String token, Users user) {
		// TODO getDATE AND TIME both
		
		this.user = user;
		this.token = token;
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		Date date = new Date(c.getTime().getTime());
		this.expiryDate = date;
	
	}
	  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private String token;
  
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Users user;
  
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    public PasswordResetToken() {
    	
    }
    
    public PasswordResetToken(PasswordResetToken passwordResetToken) {
    	this.expiryDate = passwordResetToken.expiryDate;
    	this.id = passwordResetToken.id;
    	this.token = passwordResetToken.token;
    	this.user = passwordResetToken.user;
    }
}
