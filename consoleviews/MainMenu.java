package com.revature.consoleviews;
import java.util.Scanner;
import com.revature.models.User;
import com.revature.services.UserService;

public class MainMenu {
    UserService userService = new UserService();
    public void view(){
        // temp hardcoded User
        //User user = new User("rt123", "rev12345", "Raf", "Treads");
        Scanner scanner = new Scanner(System.in); // Create scanner object
        Boolean running = true;
        // Use while loop to create a stable menu
        while(running){
            System.out.println( "**************\nGrocery List Time!\n1) login\n2) register\n0) exit" );
            String input = scanner.nextLine();

            switch(input) {
                case "1":
                    // Receive input for username
                    System.out.print("Username: ");
                    String usernameInput = scanner.nextLine();
                    // Receive input for password
                    System.out.print("Password: ");
                    String passwordInput = scanner.nextLine();

                    Boolean areCredentialsValid = userService.validateCreds(new User(usernameInput, passwordInput));

                    if (areCredentialsValid){
                        System.out.println("Welcome!");
                    }else{
                        System.out.println("Invalid username or password");
                    }
                    break;
                case "2":
                    // Receive input for user object parameters
                    System.out.print("Username: ");
                    String usernameInputreg = scanner.nextLine();
                    System.out.print("Password: ");
                    String passwordInputreg = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstnameInputreg = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastnameInputreg = scanner.nextLine();

                    // create temp User object with parameter input
                    User userToCreate = new User(usernameInputreg, passwordInputreg, firstnameInputreg, lastnameInputreg);
                    
                    User userFromDB = this.userService.getUserGivenUsername(usernameInputreg);

                    //Boolean isUsernameInStore = false;
                    
                    if(userFromDB != null){
                        System.out.println("User exists, can't create user");
                    }else{
                        userService.createUser(userToCreate);
                    }
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }
    }
}
