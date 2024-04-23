package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.customer.Customer;
import com.app.customer.ServicePlan;

public class PopulateData {
	
	private static int index = 0;
	
	public static List<Customer> populateList() {
		List<Customer> customers = new ArrayList<>(
				Arrays.asList(new Customer("Kshitij", "Tripathi", "kshitij@gmail.com" ,"Qwerty@123$",ServicePlan.valueOf("GOLD"), LocalDate.parse("2002-03-31"),2000),
						new Customer("Aditya", "Tripathi", "aditya@gmail.com" ,"Qwerty@1234$",ServicePlan.valueOf("PLATINUM"), LocalDate.parse("2004-01-31"),10000),
						new Customer("Mayur", "Badgujar", "mayur@gmail.com" ,"Qwerty@12345$",ServicePlan.valueOf("SILVER"), LocalDate.parse("2005-09-11"),1000),
						new Customer("Priya", "Singh", "priya@gmail.com" ,"Qwerty@1236$",ServicePlan.valueOf("DIAMOND"), LocalDate.parse("1999-03-31"),5000),
						new Customer("Rohit", "Inchale", "rohit@gmail.com" ,"Qwerty@23$",ServicePlan.valueOf("PLATINUM"), LocalDate.parse("2002-03-31"),10000),
						new Customer("Rahul", "Soni", "rahul@gmail.com" ,"Qwerty@43$",ServicePlan.valueOf("GOLD"), LocalDate.parse("1997-09-11"),2000)));
		
		return customers;
}
	public static Map<String,Customer> populateMap() {
		Map<String, Customer> customerMap = new HashMap<>();
		List<Customer> customers = populateList();
		for (Customer c : customers)
		{
			customerMap.put(c.getCustomerId(), c);
		}
		
		return customerMap;
}
}