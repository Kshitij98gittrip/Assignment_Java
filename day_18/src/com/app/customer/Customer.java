package com.app.customer;

import java.time.LocalDate;

import customer_exceptions.CustomerExceptions;

import static validations.CustomerValidations.*;

public class Customer {
	
	private int customerId;
	private static int count;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private ServicePlan plan;
	private double registrationAmount;
	private boolean isActive;
	
	public Customer(String fName, String lName, String email, String psswd,
			ServicePlan plan, LocalDate dob,double regAmount) {
		
		customerId = ++count;
		firstName = fName;
		lastName = lName;
		this.email = email;
		password = psswd;
		this.dob = dob;
		this.plan = plan;
		registrationAmount = regAmount;
		isActive = true;
	}
	
	public Customer(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[Customer Name: "+firstName+" " +lastName+" EmailId: "+email+
		        " Registration Amount: "+registrationAmount+" Plan: "+plan+"]";
	}
	

	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Customer) {
			
			Customer otherCustomer = (Customer) o;
			
			return this.email.equals(otherCustomer.email);
		}
		
		return false;
		
	}
	
	//getter to get the account no
	public String getCustomerId() {
		return email;
	}
	
	//getter for password
	public String getPassword() {
		return password;
	}
	
	//setter for password
	public void setPassword(String newPass) throws CustomerExceptions  {
		validatePassword(newPass);
		password = newPass;
	}
	
	//setter for setting the active status of customer to false if unsubscribed
	public void setIsActive() {
		isActive = false;
	}
	
	//getter to get the current active status
	public boolean getIsActive() {
		return isActive;
	}

}
