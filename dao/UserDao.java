package com.revature.dao;
import com.revature.models.*;
import java.util.List;

/*
 * DAO = Data Access Objects
 *      - PURPOSE: to act as interface to DB
 *      - We will be manipulating the "Store" through the DAO and not directly from elsewhere in the program
 * INTERFACES
 *      - This file defines the INTERFACES only, and not the meat/logic of the methods contained
 *      - This allows for multiple implementations of the same base methods for different functions
 *              (i.e.  a different implementation for ArrayLists, SQL, OracleDB, etc, but ALL using the method framework of this interface)
 *      - It's the IMPLEMENTATIONS that fill in the "meat" of the methods
 * 
 * WHAT METHODS FOR THIS INTERFACE?
 *  - save user to data storage
 *  - get all users from storage
 *  - get specific user from storage
 */

public interface UserDao {
    // Vars in an interface are *implicitly*:        ---public static final--- ('final' makes variables immutable)
    // Methods in an interface are *implicitly*:     ---public abstract---
    // Methods in an interface are considered ABSTRACT METHODS (No Body Methods to be defined in implementation)

    // getAllUsers() abstract method, returns a List of User objects (which is an ArrayList as defined in Store.java)
    List<User> getAllUsers(); 
    
    // getUserByUsername abstract method, takes a username string and returns a matching User object
    User getUserByUsername(String username);

    // createUser abstract method, takes a User object (to be added to data storage in implementation) and returns nothing
    void createUser(User user);
}
