package com.revature.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.User;

// DAO with JDBC Postgres

// DAO Data Access Object
//  - isolates persistence layer from app logic
//  - generally a dao for each model

// JDBC Java DataBase Connectivity
//  - is a tech allowing Java to connect to a DB
//  - is modular, not only used with one DB system

// 4 things req to connect to DB
//  - endpoint, uname, pass, drivers

/*
 * Important classes and interfaces utilizing JDBC
 *  -DriverManager class
 *      - utilized for managing jdbc droivers
 *      - getConnection method establishes an active connection to db
 *  - Connection interface
 *      - where active connection will be stored
 *  - Statement interface
 *      - obj that represents a SQL statment
 *      - does NOT protect VS SQL injection
 *  - PreparedStatement interface
 *      - DOES protect VS SQL injection
 *  - CallableStatement interface
 *      - deals with stored procedures
 *  - ResultSet interface
 *      - objects that hold the query result virtual table
 * 
 * 
 * "No Suitable Driver Found"
 *  - url has a typo
 *  - you didn't add the dependency in pom.xml
 *  - forgot "jdbc:postgresql://" before the endpoint URL
 */

public class UserDaoImpl implements UserDao {
    // CONNECTION INFO
    private final String url ="jdbc:postgresql://sandbox.cprjerwhpjzg.us-east-1.rds.amazonaws.com/postgres";
    private final String username = "rafael";
    private final String password = "Dookie80!";
    
    @Override
    public List<User> getAllUsers(){
        // Create a collection to hold info pulled from DB
        // in this case we're building a User per iteration through the ResultSet
        //      and appending that constructed User to this collection
        List<User> users = new ArrayList<>();
        try{
            // 1 - Create active connection to DB
            Connection conn = DriverManager.getConnection(this.url,this.username,this.password);
            // 2 - Set up qry string
            String sql = "select * from users";
            // 3 - Use PreparedStatement (safe vs sql injection, checks for it); only sets up the query statement
            PreparedStatement ps = conn.prepareStatement(sql);
            // 4 - Set up ResultSet using executeQuery which actually does the query and return a result set
            ResultSet rs = ps.executeQuery();
            // 5 - Iterate over ResultSet.  Use a collection to capture the results
            //      rs.next() moves cursor to next entry/row, starts outside of the table
            while(rs.next()){
                // rs.get* methods grab info according to the column Index (index in order as schema was created)
                // here, we create a new user based on the info grabbed from that cursor position
                // the constructed User is added to our preset collection 'users'
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5)));
            }
            // 6 - ensure connection is closed when done
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username){
        User user = null;
        try{
            // 1 - Create active connection to DB
            Connection conn = DriverManager.getConnection(this.url,this.username,this.password);
            // 2 - Set up qry string
            String sql = "select * from users where username = ?";
            // 3 - Use PreparedStatement 
            PreparedStatement ps = conn.prepareStatement(sql);
            //  How to insert value into query
            //      - in sql query above, '?' is used as a value placeholder
            //      - use psObj.set* to set the value to take place of ?
            //             - param1 = which ?, param2 = value
            ps.setString(1, username);
            // 4 - Set up ResultSet 
            ResultSet rs = ps.executeQuery();
            // 5 - Iterate over ResultSet. 
            while(rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5));
            }
            // 6 - ensure connection is closed when done
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user){
        // TRY WITH RESOURCES - to auto-close an object when it should be closed
        //          so you don't need explicit conn.close();
        // 1 - Create active connection to DB in try w/ resources parenths
        try(Connection conn = DriverManager.getConnection(url,username,password)){
            
            // 2 - Set up qry string
            String sql = "insert into users (username, passwd, firstname, lastname) values (?,?,?,?)";
            // 3 - Use PreparedStatement 
            PreparedStatement ps = conn.prepareStatement(sql);
            // 4 - set up replacements for ? value placeholders, in order
            //      (there are 'set' methods for different datatypes)
            //  in this case a User object is passed in from a temp User object to add
            // so we use it's class GET methods to obtain the values
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            // 5 - execute the DML statement
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
