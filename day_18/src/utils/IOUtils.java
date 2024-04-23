package utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Stream;

import com.app.customer.Customer;

public interface IOUtils {

	public static void storeCustomerDetailsBin(String filename, Customer customer) throws IOException, ClassNotFoundException, InvalidClassException{
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));){
			out.writeObject(customer);
		}
		
	}
	
	public static Object restoreCustomerDetailsBin(String filename) throws IOException, ClassNotFoundException, InvalidClassException{
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			return in.readObject();
		}
	}
	
	public static void storeCustomerDetailsToText(String filename, Customer customer) throws IOException, ClassNotFoundException, InvalidClassException{
		
		try(PrintWriter out = new PrintWriter(new FileWriter(filename))){
			out.println(customer);
		}
	}
	
	public static Stream restoreCustomerDetailsFromText(String filename) throws IOException, ClassNotFoundException, InvalidClassException{
		try(BufferedReader in = new BufferedReader(new FileReader(filename))){
			return in.lines();
		}
	}
}
