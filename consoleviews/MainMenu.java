package com.revature.consoleviews;
import java.util.Scanner;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.InputUtil;

public class MainMenu {
    // Create UserService object to access core functions
    UserService userService = new UserService();
    // Create InputUtil object to access menu messaging/input functions
    InputUtil inputUtil = new InputUtil();

    // Main Menu Function
    public void view(){
        Scanner scanner = new Scanner(System.in); // Create scanner object, passing 'System.in' is essential to enable keyboard input
        Boolean running = true;  // Var to control the while loop state
        // While loop is used to implement a persistent menu that ends only upon quit (or error)
        while(running){
            // Menu display & input prompt
            System.out.println( "**************\nGrocery List Time!\n1) login\n2) register\n0) exit" );
            String input = scanner.nextLine();
            // Menu logic
            switch(input) {
                case "1":
                    //     *** 1) login ***
                    // Receive input for username & password
                    String usernameInput = inputUtil.retrieveString("Username: ");
                    String passwordInput = inputUtil.retrieveString("Password: ");
                    // call validateCreds from UserService.java to check input
                    Boolean areCredentialsValid = userService.validateCreds(new User(usernameInput, passwordInput));
                    // Messaging to inform user of login success or credential failure
                    // To be replaced with appropriate Login Code (new "view" for login)
                    if (areCredentialsValid){
                        System.out.println("Welcome!");
                    }else{
                        System.out.println("Invalid username or password");
                    }
                    break;
                case "2":
                    //     *** 2) register ***
                    // Receive input to use as user object parameters
                    String usernameInputreg = inputUtil.retrieveString("Username: ");
                    String passwordInputreg = inputUtil.retrieveString("Password: ");
                    String firstnameInputreg = inputUtil.retrieveString("First Name: ");
                    String lastnameInputreg = inputUtil.retrieveString("Last Name: ");

                    // create temp User object with above input as parameters, which will be added to storage IF the username is unique
                    User userToCreate = new User(usernameInputreg, passwordInputreg, firstnameInputreg, lastnameInputreg);
                    // pass the input string for username into the UserService.java method createUser
                    // it returns null IF the username already exists, which will fail the registration in the code just below
                    User userFromDB = userService.createUser(userToCreate);
                    
                    // Add user to storage only IF there is no existing user (i.e. you got a null value from the previous check [line48])
                    if(userFromDB == null){
                        System.out.println("User exists, can't create user");
                    }else{
                        // call createUser() from UserService.java, which leverages createUser() from UserDaoJavaImpl.java 
                        userService.createUser(userToCreate);
                        System.out.println("User created");
                    }
                    break;
                case "0":
                    //     *** 0) quit ***
                    // Negate the CONTROL BOOLEAN and break to kill the program loop
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
