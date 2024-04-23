package text_io;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.Map;

import com.app.customer.Customer;

import utils.IOUtils;

public class StoreCustomerData {
	
	public static void storeCustomers(String filename,Map<String,Customer> customers)
			throws IOException, ClassNotFoundException, InvalidClassException{
		
		for(Customer c: customers.values())
			IOUtils.storeCustomerDetailsToText(filename, c);
		
		
	}
}
