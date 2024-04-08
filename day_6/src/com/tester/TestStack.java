package com.tester;

import java.util.Scanner;

import com.stack.*;

public class TestStack {

    public static void main(String[] args) {

        Scanner sc  =  new Scanner(System.in);
        Stack stack = null;
        boolean exit = false;

        while(!exit) {

            Helper.displayMenu();

            switch (sc.nextInt()) {
                case 1:

                    stack = Helper.createStack(new FixedStack());
                    break;

                case 2:

//                    stack = Helper.createStack(new GrowableStack());
                    System.out.println("Growable stack");
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



