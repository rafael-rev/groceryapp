package com.revature.dao;
import com.revature.models.GroceryItem;
import java.util.List;

public interface GroceryItemDao {
    void createGroceryItem(GroceryItem groceryItem);

    List<GroceryItem> getAllItemsGivenUserId(Integer userId);

    void deleteGroceryItem(Integer groceryItemId);

    void markGroceryItemInCart(Integer groceryItemId);
}
