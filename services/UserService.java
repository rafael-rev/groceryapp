package com.revature.services;
import com.revature.store.*;
import com.revature.models.User;

import com.revature.dao.*;

/*
    * Service Layer is for Business Logic
    *   - if you need to write an alg to meet a requirement of project, it happens in THIS layer
     * METHODS:
     * - Validate creds
     * - get User object from a given username
     * - add the User object to storage
     */
public class UserService {
    // Create Dao object for interaction with storage
    UserDao userDao = new UserDao();

    public boolean validateCreds(User credentials) {
        // method to validate the credentials of a given User object
        // see line 28 in MainMenu.java --> checks input with a temporary User object based off of only username & password

        // call getUserGivenUsername in attempt to get the user referenced by the given one's username
        User userFromStore = getUserGivenUsername(credentials.getUsername()); 
        
        // if the result of the line above is null, return false
        if (userFromStore == null) {
            return false;
        } // if the result of that line is *not* null, compare the password with the one given by the "credentials" User object,
        // and return true if it checks out
        if (userFromStore.getPassword().equals(credentials.getPassword())) {
            return true;
        }
        // if the password check fails, return false
        return false;
    }

    public User getUserGivenUsername(String username){
        // method to get a User object from storage based on a given username
        // returns a User object

        // Start with a default null User object
        User userFromDB = null;
        // use the Dao object getAllUsers() method to get an array of existing Users, and iterate through them
        for(User user : userDao.getAllUsers()){
            if(user == null){
                break;
            }
            // use the User object Getter for username, and compare it's value to the given username
            // if they match, set the temp 'userFromDB' from null to that user, so it may be returned
            if(user.getUsername().equals(username)){
                userFromDB = user;
                break;
            }
        }
        return userFromDB;
    }

    // ****Must be refactored to use userDao and not Store directly*****
    public void createUser(User userToCreate){
        //User[] usersFromDB = userDao.getAllUsers();
        for(int i=0; i < Store.users.length; i++){
            if(Store.users[i] == null){
                Store.users[i] = userToCreate;
                break;
            }
        }
    }
}
