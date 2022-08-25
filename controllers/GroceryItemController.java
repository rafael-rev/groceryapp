package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GroceryItem;
import com.revature.models.JsonResponse;
import com.revature.services.GroceryItemService;
import io.javalin.http.Context;

public class GroceryItemController {
    GroceryItemService giService = new GroceryItemService();
    
    // endpoint to get all grocery items given UID
    public void getAllGroceryItemsGivenUID(Context ctx){
        // get the user ID (could also get it from Session user)
        Integer userId = Integer.parseInt(ctx.pathParam("userId"));
        // get the list of grocery items
        List<GroceryItem> items = giService.getAllGroceryItemsGivenUID(userId);

        ctx.json(new JsonResponse(true, "retrieving all items for userID "+userId, items));
    }

    public void createItem(Context ctx){
        //need groc item sent to it
        GroceryItem item = ctx.bodyAsClass(GroceryItem.class);
        // get session User to access UID, so we can use that to populate new Item FK
        // -> 


        giService.createGroceryItem(item);

        ctx.json(new JsonResponse(true, "Item created", null));
    }

    public void deleteItem(Context ctx){
        // only need an item ID
        Integer grocItemID = Integer.parseInt(ctx.pathParam("itemID"));

        giService.deleteGroceryItemGivenGrocID(grocItemID);

        ctx.json(new JsonResponse(true, "Item deleted if exists", null));

    }

    public void markItemComplete(Context ctx){
        // only need an item ID
        Integer grocItemID = Integer.parseInt(ctx.pathParam("itemID"));

        giService.markInCartGivenGroceryItem(grocItemID);

        ctx.json(new JsonResponse(true, "Item marked if exists", null));
    }
}
