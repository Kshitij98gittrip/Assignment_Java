package com.stack;

import com.customer.*;

public class GrowableStack implements Stack {
	private int size = STACK_SIZE;
	private int count = 0;
	private Customer[] customer;

	public GrowableStack() {
	
		customer = new Customer[size];
	}

	public void growableArray() {
		
		Customer[] temp = new Customer[size*2];
		for (int i = 0; i < size; i++) {
			
			temp[i] = customer[i];
		}
		
		customer = temp;
	}


	public void push(Customer element) {
		
		if (count >= size) {
			growableArray();
		}
		
		customer[count] = element;
		count++;
	}

	public Customer pop() {

		if (count > 0) {
			return customer[--count];
		} else {
			System.out.println("Error: Stack Empty. Can't pop elements.");
			return null;
		}
	}

	public void peek() {

		if (count > 0)
			System.out.println(customer[count - 1]);

		else
			System.out.println("Error: Stack empty");

	}

	public int stackSize() {
		return count;
	}
	
	

}
