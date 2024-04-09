package com.customer;

public class Customer {
	
	private static int id = 0;
	private String name;
	private String address;
	
	public Customer(String name, String address) {
		
		++id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer id = "+id+" Customer name = "+name+" Customer address = "+address;
	}
}
