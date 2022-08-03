package com.revature.dao;
import com.revature.store.*;
import com.revature.models.*;
/*
 * 
 * WHAT METHODS?
 *  - save user to data storage
 *  - get all users
 */

public class UserDao {
    // method return value "User[]" is an array of type User
    public User[] getAllUsers(){
        return Store.users;
    }
}
