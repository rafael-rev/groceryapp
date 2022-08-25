package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.GroceryItem;

public class GroceryItemDaoImpl implements GroceryItemDao {
    private final String url ="jdbc:postgresql://sandbox.cprjerwhpjzg.us-east-1.rds.amazonaws.com/postgres";
    private final String username = "rafael";
    private final String password = "Dookie80!";

    @Override
    public void createGroceryItem(GroceryItem groceryItem){
        try(Connection conn = DriverManager.getConnection(this.url,this.username,this.password)){
            String sql = "insert into grocery_items (name,qty,user_id_fk) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
                
            ps.setString(1, groceryItem.getName());
            ps.setInt(2, groceryItem.getQty());
            ps.setInt(3, groceryItem.getUserIdFk());  
            ps.executeUpdate(); 
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<GroceryItem> getAllItemsGivenUserId(Integer userId){
        List<GroceryItem> itemList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(this.url,this.username,this.password)){
            String sql = "select * from grocery_items where user_id_fk = ? order by groc_id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                itemList.add(new GroceryItem(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getBoolean(4),rs.getInt(5)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public void deleteGroceryItem(Integer groceryItemId){
        try(Connection conn = DriverManager.getConnection(this.url,this.username,this.password)){
            String sql = "delete from grocery_items where groc_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,groceryItemId);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }    

    @Override
    public void markGroceryItemInCart(Integer groceryItemId){
        try(Connection conn = DriverManager.getConnection(this.url,this.username,this.password)){
            String sql = "update grocery_items set incart = true where groc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,groceryItemId);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
