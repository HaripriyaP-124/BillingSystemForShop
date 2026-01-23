package com.wipro.bss.entity;

public class User {
	private String userId;
	private String name;
	private String contactNumber;
	public User(String userId, String name, String contactNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
