package com.bonyzone.web.model;

import java.io.Serializable;

public class UserTO implements Serializable{

	private static final long serialVersionUID = -4264512583000907001L;
	private long userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String address;
	private String last4digitcc;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLast4digitcc() {
		return last4digitcc;
	}
	public void setLast4digitcc(String last4digitcc) {
		this.last4digitcc = last4digitcc;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "User [first name=" + firstName + ", last name=" + lastName + ", " +"email=" + email + "]";
	}
}
