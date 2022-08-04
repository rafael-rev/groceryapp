package com.revature.util;

import java.util.Scanner;

/*
 * Utility class made to handle user input AND menu messaging for the console app
 */

public class InputUtil {
    // Declare scanner input object
    Scanner scanner = new Scanner(System.in);
    
    public String retrieveString(String msg){
        // Method to print a message to the user and prompt for a String input
        // Returns the input to be used in other parts of the program
        System.out.print(msg);
        return scanner.nextLine();
    }

    public Integer retrieveInt(String msg){
        // Method to print a message to the user and prompt for a Integer input
        // Checks for NumberFormatException to handle incorrect non-Integer input
        // Returns the input to be used in other parts of the program
        
        // First some control vars
        //  num: will contain the value of the scanner input, if it's an Integer.
        //          it's declared outside of the loop so it may be returned when the loop breaks (SCOPE)
        //  valid: the loop control variable
        Integer num = 0;
        Boolean valid = false;
        // NOTE the "not" operator (!) which effectively makes 'valid' true
        while(!valid){
            System.out.println(msg);
            // try-catch to account for non-Integer inputs.  When the exception is caught, 
            //      the program loops back to the input message rather than crash
            try{
                num = Integer.parseInt(scanner.nextLine());
                // If a valid Integer was input, close the loop
                valid = true;
                break;
            }catch(NumberFormatException nfe){
                System.out.println("Input is not an integer, try again.");
            }
        }
        // When the loop is closed, return the valid Integer
        return num;
    }
}
