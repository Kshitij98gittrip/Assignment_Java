package com.stack;

import com.customer.Customer;

public class FixedStack implements Stack{

    private int size = STACK_SIZE;
    private Customer[] customer = new Customer[size];
    private int counter = 0;


    @Override
    public void push(Customer element) {

        if (counter < size)
            customer[counter++] = element;

        else
            System.out.println("Error: Stack Overflow");
    }

    @Override
    public Customer pop() {
        if (counter > 0) {
            return customer[--counter];
        }
        else{
            System.out.println("Error: Stack Empty. Can't pop elements.");
            return null;
        }
    }

    @Override
    public void peek() {
        if (counter > 0)
            System.out.println(customer[counter-1]);
        else
            System.out.println("Error: Stack Empty");

    }
}
