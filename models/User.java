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
    private String username, password, firstname, lastname = "";


    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    

    public User(String username, String password){
        this.username = username;
        this.password = password;
        
    }

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
