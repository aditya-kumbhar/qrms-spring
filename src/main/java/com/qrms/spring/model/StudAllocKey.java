package com.qrms.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class StudAllocKey implements Serializable{

	private Course courseId;
	private String userName;
}
