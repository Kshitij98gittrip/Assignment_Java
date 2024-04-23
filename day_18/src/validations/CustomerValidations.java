package validations;

import static java.time.LocalDate.parse;
import static utils.CustomerUtils.searchCustomer;

import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Pattern;

import com.app.customer.Customer;
import com.app.customer.ServicePlan;

import customer_exceptions.CustomerExceptions;

public class CustomerValidations {
	
	//Validate all the inputs
	public static Customer validateInputs(
			String fName, String lName, String email, String psswd,
			String plan, String dob, double regAmount, Map<String, Customer> customers) 
			throws IllegalArgumentException, CustomerExceptions{
		
		LocalDate parsedDOB = parse(dob);
		validateName(fName, lName);
		validateEmail(email);
		validatePassword(psswd);
		ServicePlan servicePlan = validatePlan(plan);
		validateRegistrationAmount(servicePlan, regAmount);
		
		return new Customer(fName, lName, email, psswd,
			servicePlan, parsedDOB, regAmount);
		
	}
	
	//Validate first and last name of the customer
	public static void validateName(String fName, String lName) 
			throws CustomerExceptions{
			
			if (fName.length() < 3 || lName.length() < 3) 
				throw new CustomerExceptions("Invalid Name");
			
		}
	
	//Validate email of the customer 
	public static void validateEmail(String email) 
			throws CustomerExceptions{
		
		String emailRegex = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		
		Pattern emailPattern = Pattern.compile(emailRegex);
		
		if (email == null || (!emailPattern.matcher(email).matches()))
			throw new CustomerExceptions("Invalid Email Id.!!!!");
		
	}
	
	//Validate password of the customer
	public static void validatePassword(String password)
			throws CustomerExceptions{
		
		String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern passwordPattern = Pattern.compile(passwordRegex);
		
		if (password == null || (!passwordPattern.matcher(password).matches()))
			throw new CustomerExceptions("Invalid password. Password must be greater than 8 and contains capital letters, small letters and special character!!!");		
	}

	//Validate and parsing the Service plan
	public static ServicePlan validatePlan(String plan) 
			throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	//Validate the  registration amount with the different Service plan
	public static void validateRegistrationAmount(ServicePlan plan, double regAmount)
			throws CustomerExceptions{
		
		if (regAmount != plan.getPlanAmount()) 
			throw new CustomerExceptions("Registration amount is not equal to plan amount");
	}
	
	//Validate the customer credential for SignIn 
	public static String validateCredentials(Map<String, Customer> customer, String email, String password) 
			throws CustomerExceptions{
			
			Customer custValidate = searchCustomer(customer, email);
			
			if (!(custValidate.getPassword().equals(password)) || (custValidate.getIsActive()==false))
				throw new CustomerExceptions("Password doesn't match with the existing password or customer is unsubscribed!");
			
			return "SignIn successful";
				
		}
	
	
}
