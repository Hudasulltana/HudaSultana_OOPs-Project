package com.shoppingApp.in;

public class Customer {
	private String EmailID;
	private String password;
	
	Customer(String EmailID, String password){
		this.EmailID = EmailID;
		this.password = password;
	}

	public String getEmailID() {
		return EmailID;
	}
	
	public boolean checkDetails(String password){
		if(this.password == password) {
			return true;
		}
		else return false;
	}
	
	public boolean Login(String password) {
		if(checkDetails(password)) {
			return true;
		}
		else return false;
	}
}
