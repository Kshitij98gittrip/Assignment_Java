package com.stack;

import com.customer.Customer;

public interface Stack {

    int STACK_SIZE = 100;

    void push(Customer element);
    Customer pop();
    void peek();
}

