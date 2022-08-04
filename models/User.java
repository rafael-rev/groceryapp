package com.revature.models;

/*
 * models package will hold classes w/o functionality
 * their sole purpose is to make a new data type we can transfer across app
 * 
 * Encapsulation = restriction of direct access (ex. vending machine, you just don't get the soda,
 * the machine is a medium you have to go through & pass its requirement)
 * 
 * We restrict access using ACCESS MODIFIERS
 */

public class User {
    // Declare Instance Variables
    private String username, password, firstname, lastname = "";

    // All Parameter Constructor
    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    // 2 Parameter Constructor (for creating a temp User object for validating credentials)
    public User(String username, String password){
        this.username = username;
        this.password = password;
        
    }

    // Getters & Setters for Instance Variables
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Polymorphistic Overriding of toString method of Object parent class
    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            "}";
    }
}
