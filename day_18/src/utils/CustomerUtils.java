package utils;

import java.util.Map;

import com.app.customer.Customer;

import customer_exceptions.CustomerExceptions;

public class CustomerUtils {

	//Search the customer in the list if it exists or not
	public static Customer searchCustomer(Map<String, Customer> customers, String email) throws CustomerExceptions{
		
		
		Customer customer = customers.get(email);
		
		if (customer == null)
			throw new CustomerExceptions("Email Id not found!!");
		
		return customer;
		
	}
	
	
}
