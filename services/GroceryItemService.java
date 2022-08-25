package com.revature.services;

import java.util.List;

import com.revature.dao.GroceryItemDaoImpl;
import com.revature.models.GroceryItem;

public class GroceryItemService {

    GroceryItemDaoImpl groceryItemDao = new GroceryItemDaoImpl();

    public void createGroceryItem(GroceryItem groceryItem){
        this.groceryItemDao.createGroceryItem(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItemsGivenUID(Integer userId){
        return this.groceryItemDao.getAllItemsGivenUserId(userId);
    }

    public void deleteGroceryItemGivenGrocID(Integer grocID){
        this.groceryItemDao.deleteGroceryItem(grocID);
    }

    public void markInCartGivenGroceryItem(Integer itemID){
        this.groceryItemDao.markGroceryItemInCart(itemID);
    }

}
