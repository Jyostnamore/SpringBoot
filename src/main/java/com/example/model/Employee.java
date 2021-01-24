package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	


public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", city=" + city + ", address=" + address  + ", mobile_no=" + mobile_no + "]";
	}
public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

public Long getId() {
		return id;
	}

@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
	@Column(name="firstname")
	
 private String firstname;
 @Column(name="lastname")
 private String lastname;
 @Column(name="email")
 private String email;
@Column(name="city")
 private String city;
@Column
 private String address;
@Column

 private Long mobile_no;
@Column
private Date date;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public void setId(Long id) {
	this.id = id;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}




public Employee(Long id, String firstname, String lastname, String email, String city, String address, Long mobile_no,
		Date date) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.city = city;
	this.address = address;
	this.mobile_no = mobile_no;
	this.date = date;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
}
