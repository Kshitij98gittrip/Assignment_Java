package tester;

import static utils.CustomerUtils.searchCustomer;
import static validations.CustomerValidations.validateCredentials;
import static validations.CustomerValidations.validateInputs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.customer.Customer;

import text_io.StoreCustomerData;
import static  utils.PopulateData.*;

public class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc = new Scanner(System.in);)
		{
//			List<Customer> customers = new ArrayList<>();
			Map<String,Customer> customers = new HashMap<>(populateMap());
			
			boolean exit = false;
			
			//Menu Driven
			while(!exit) {
				
				//Menu options
				System.out.println("--Options--"
						+ "\n1. Signup New Customer"
						+ "\n2. Signin Customer"
						+ "\n3. Change password"
						+ "\n4. UnSubscribe customer"
						+ "\n5. Display all customer"
						+ "\n6. Store details in text file."
						+ "\n0. Exit.");
				
				System.out.println("Enter your choice");
				
				try {
					
					switch(sc.nextInt()) {

					case 1: 
						System.out.println("\nSignup Customer.");
						System.out.println("Input type: [String fName, String lName, String email, String psswd, String plan, String dob(yyyy-MM-dd),double regAmount ]");
						Customer customer = validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),customers);
						customers.put(customer.getCustomerId(),customer);
						System.out.println("Customer Registered successfully !!");
						break;
				
					case 2: 
						System.out.println("SignIn Customer.");
						System.out.println("Enter your email and password.");
						System.out.println(validateCredentials(customers, sc.next(), sc.next()));
						break;
						
					case 3:
						System.out.println("Change password");
						System.out.println("Enter your emailId");
						Customer searchedCust = searchCustomer(customers, sc.next());
						System.out.println("Enter the new password. ");
						searchedCust.setPassword(sc.next());
						System.out.println("Password changed successfully!!");
						break;
						
					case 4:
						System.out.println("UnSubscribe customer");
						System.out.println("Enter your mail id");
						searchedCust = searchCustomer(customers, sc.next());
						searchedCust.setIsActive();
						System.out.println("Unsubscribed Successfully.");
						break;
						
					case 5:
						System.out.println("Displaying customer list");
						for (Customer c: customers.values()) {
							System.out.println(c);
						}
						
						break;
						
					case 6:
						System.out.println("Storing data in text file.");
						System.out.println("Enter file name: ");
						String filename = sc.nextLine();
						StoreCustomerData.storeCustomers(filename,customers);
							
					default:
						exit = true;
						System.out.println("Exit successful.");
							
					}
					

				}
				catch (Exception e) {
					//to get all the extra buffers from the scanner
					sc.nextLine();
					//displaying exception
					System.out.println(e);
				}
			}
		}
		
		

	}

}
