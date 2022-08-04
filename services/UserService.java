package com.revature.services;
import com.revature.models.User;
import com.revature.dao.*;

/*
    * Service Layer is for "Business Logic"
    *   - if you need to write an alg to meet a requirement of project, it happens in THIS layer
    *   - you DO NOT want direct data source access from this layer, but rather leverage the DAO
     * METHODS:
     * - Validate creds (of user logging in)
     * - get User object from a given username
     * - add the User object to storage
*/

public class UserService {
    // Create Dao object from **DAO Implementation** for interaction with storage
    UserDaoJavaImpl userDao = new UserDaoJavaImpl();

    public boolean validateCreds(User credentials) {
        // method to validate the credentials of a given User object
        // see line 30 in MainMenu.java --> checks input with a temporary User object based off of only username & password

        // Use getUserByUsername from UserDaoJavaImpl.java in attempt to find an existing user in storage, 
        //      based on the username of the given 'credentials' User argument
        // getUserByUsername returns 'null' if no match found
        User userFromStore = userDao.getUserByUsername(credentials.getUsername()); 
        
        // if the result of the line above is null, return false (username fail)
        if (userFromStore == null) {
            return false;
        } // if the result of that line is *not* null, compare the password with the one given by the "credentials" User object,
        //      and return true if it checks out
        if (userFromStore.getPassword().equals(credentials.getPassword())) {
            return true;
        }
        // if the password check fails, return false
        return false;
    }

    public User getUserGivenUsername(String username){
        // leverages getUserByUsername from UserDaoJavaImpl.java to locate and return the User object 
        //      whose username property matches the given username query
        // returns 'null' if no match found
        return userDao.getUserByUsername(username);
    }

    public User createUser(User userToCreate){

        // Check for dupes first
        // method getUserByUsername from the Dao Implementation will handle this
        // NOTE: This 'userFromDb' is NOT the same variable as 'userFromDB' in MainMenu.java, NOR 'userFromDB' 
        //      in UserDaoJavaImpl.java, and each have different reasons for null values
        User userFromDb = userDao.getUserByUsername(userToCreate.getUsername());
        // Effectively, if there is no existing user by that name found (null), create the User and return that User object
        if(userFromDb == null){
            userDao.createUser(userToCreate);
            return userToCreate;
        }
        // Otherwise (if user exists) return null, which will be used in other funcs
        return null;
    }
}
