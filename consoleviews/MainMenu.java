package com.revature.consoleviews;
import java.util.Scanner;
import com.revature.models.User;
import com.revature.services.UserService;

public class MainMenu {
    // Create UserService object to access core functions
    UserService userService = new UserService();

    // Main Menu Function
    public void view(){
        Scanner scanner = new Scanner(System.in); // Create scanner object
        Boolean running = true;  // Var to control the while loop state
        while(running){
            // Menu display & input prompt
            System.out.println( "**************\nGrocery List Time!\n1) login\n2) register\n0) exit" );
            String input = scanner.nextLine();
            // Menu logic
            switch(input) {
                case "1":
                    // *** 1) login ***
                    // Receive input for username & password
                    System.out.print("Username: ");
                    String usernameInput = scanner.nextLine();
                    System.out.print("Password: ");
                    String passwordInput = scanner.nextLine();
                    // call validateCreds from UserService to check input
                    Boolean areCredentialsValid = userService.validateCreds(new User(usernameInput, passwordInput));
                    // Messaging to inform user of login success or credential failure
                    if (areCredentialsValid){
                        System.out.println("Welcome!");
                    }else{
                        System.out.println("Invalid username or password");
                    }
                    break;
                case "2":
                    // *** 2) register ***
                    // Receive input to use as user object parameters
                    System.out.print("Username: ");
                    String usernameInputreg = scanner.nextLine();
                    System.out.print("Password: ");
                    String passwordInputreg = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstnameInputreg = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastnameInputreg = scanner.nextLine();

                    // create temp User object with parameter input, which will be added to storage if the username is unique
                    User userToCreate = new User(usernameInputreg, passwordInputreg, firstnameInputreg, lastnameInputreg);
                    // pass the input string for username into the UserService method made to check for it's existence in storage
                    User userFromDB = this.userService.getUserGivenUsername(usernameInputreg);
                    
                    // Add user to storage only if there is no existing user (i.e. you got a null value from the previous check)
                    if(userFromDB != null){
                        System.out.println("User exists, can't create user");
                    }else{
                        userService.createUser(userToCreate);
                    }
                    break;
                case "0":
                    // *** 0) quit ***
                    running = false;
                    break;
                default:
                    // Default to catch invalid entries, refreshes ability to select
                    System.out.println("Please select a valid option");
                    break;
            }
        }
        scanner.close(); // close scanner object when done, to prevent resource leak
    }
}
