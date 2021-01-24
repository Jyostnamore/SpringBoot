package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLatname() {
		return latname;
	}
	public void setLatname(String latname) {
		this.latname = latname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	String email;
	@Column
	//String username;
	String firstname;
	@Column
	String latname;
	@Column
	String password;
	@Column
	String address;
	@Column
	String dob;
	@Column
	String company;
	public Manager(Long id, String email, String firstname, String latname, String password, String address, String dob,
			String company) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.latname = latname;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.company = company;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	

}
