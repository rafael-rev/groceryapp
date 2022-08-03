package com.revature.services;
import com.revature.store.*;
import com.revature.models.User;

import javax.sound.sampled.SourceDataLine;

import com.revature.dao.*;

/*
    * Service Layer is for Business Logic
    *   - if you need to write an alg to meet a requirement of project, it happens in THIS layer
     * METHODS:
     * - Validate creds
     */
public class UserService {

    UserDao userDao = new UserDao();

    public boolean validateCreds(User credentials) {
        User userFromStore = getUserGivenUsername(credentials.getUsername()); // placeholder for user to locate
        
        if (userFromStore == null) {
            return false;
        }
        if (userFromStore.getPassword().equals(credentials.getPassword())) {
            return true;
        }
        return false;
    }

    public User getUserGivenUsername(String username){
        User userFromDB = null;
        for(User user : userDao.getAllUsers()){
            if(user == null){
                break;
            }
            if(user.getUsername().equals(username)){
                userFromDB = user;
                break;
            }
        }
        return userFromDB;
    }

    // Must be refactored to use userDao and not Store directly
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
