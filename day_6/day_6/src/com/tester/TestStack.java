package com.tester;

import java.util.Scanner;

import com.stack.*;

public class TestStack {

    public static void main(String[] args) {

        Scanner sc  =  new Scanner(System.in);
        Stack stack = null;
        boolean exit = false;
        boolean flg = false;

        while(!exit) {

            Helper.displayMenu();

            switch (sc.nextInt()) {
                case 1:
                	if (!flg) {
                		stack = Helper.createStack(new FixedStack());
                		flg = true;
                	}
                	
                	else {
                		System.out.println("Instance already created.");
                	}
                    break;

                case 2:

                	if (!flg) {
                		stack = Helper.createStack(new GrowableStack());
                		flg = true;
                	}
                	
                	else {
                		System.out.println("Instance already created.");
                	}
                    break;

                case 3:
                	
                    Helper.pushElement(sc, stack);
                    break;

                case 4:
                    Helper.popElement(stack);
                    break;

                case 5:
                   Helper.peekElement(stack);
                    break;

                default:
                    exit = true;
                    sc.close();
                    System.out.println("Exited successfully!");
            }
        }


    }




}



