package com.tester;

import com.customer.Customer;
import com.stack.Stack;

import java.util.Scanner;

public class Helper {

    public static Stack createStack(Stack stack){
        if (stack!=null){
            System.out.println("Instance created for "+stack.getClass().getSimpleName());
        }
        return stack;
    }

    public static void pushElement(Scanner sc, Stack stack){
        System.out.println("==================================================================");
        System.out.println("Push elements in stack");
        System.out.println("Enter name. ");
        String name  = sc.next();
        System.out.println("Enter address. ");
        String address = sc.next();
        stack.push(createCustomer(name, address));
        System.out.println("==================================================================");
    }
    

    public static void popElement(Stack stack){
        System.out.println("____________________________________________________________________");
        System.out.println("Pop data");
        System.out.println(stack.pop());
        System.out.println("____________________________________________________________________");
    }

    public static void peekElement(Stack stack){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Displaying top element.");
        stack.peek();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static void displayMenu(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("1 for fixed stack ");
        System.out.println("2 for Growable stack ");
        System.out.println("3 to Push Element in to stack");
        System.out.println("4 to Pop Element from the stack ");
        System.out.println("5 to Peek top Element of the stack");
        System.out.println("6 to exit");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Enter your choice: ");
    }
    
    private static Customer createCustomer(String name, String address) {
    	Customer customer = new Customer(name, address);
    	return customer;
    }
}
