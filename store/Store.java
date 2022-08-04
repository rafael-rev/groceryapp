package com.revature.store;

import com.revature.models.User;
import java.util.ArrayList;
import java.util.List;

 // **OLD LIMITED WAY**
    // Creating an array that will hold 10 *USER OBJECTS*
    // regular array is limited bc you cannot add past the given number (10)
    // public static User[] users = new User[10]; 

public class Store {
    // declare an ArrayList of type "User object" to store registered users
    // ArrayLists can be expanded nigh-indefinitely
    public static List<User> users = new ArrayList<>();
}
