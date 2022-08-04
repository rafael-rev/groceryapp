package com.revature.dao;

import com.revature.store.Store;
import com.revature.models.User;
import java.util.List;

// This is an IMPLEMENTATION of UserDao.java's INTERFACE, targeting the ArrayList in Store.java
public class UserDaoJavaImpl implements UserDao {
    
    // Implementing the method getAllUsers from the INTERFACE in UserDao.java
    @Override
    public List<User> getAllUsers() {
        // simply returns the ArrayList from Store.java
        return Store.users;
    }

    // Implementing the method getUserByUsername from the INTERFACE in UserDao.java
    @Override
    public User getUserByUsername(String username){
        // method to get a User object from the ArrayList storage, based on a given username string
        // returns a User object

        // Start with a default null User object
        User userFromDB = null;
        // iterate directly over the ArrayList from Store.java and check each member
        for(User user : Store.users){
            // If the current member of the iteration is "null", break the loop
            if(user == null){
                break;
            }
            // use the User object Getter for the current member (user) of the iteration, and compare it's value to the given username
            // if they match, set the temp 'userFromDB' to that user, so that User object may be returned.  Then break the loop
            if(user.getUsername().equals(username)){
                userFromDB = user;
                break;
            }
        }
        // Finally return the User object (null if no match found)
        return userFromDB;
    }

    // Implementing the method createUser from the INTERFACE in UserDao.java
    @Override
    public void createUser(User user){
        // directly add user to end of ArrayList from Store.java
        Store.users.add(user);
    }
}
