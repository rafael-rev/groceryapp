package com.revature;
import com.revature.controllers.GroceryItemController;
import com.revature.controllers.SessionController;
import com.revature.controllers.UserController;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

/**
 * Grocery List Target Functionality
 *  - register new user
 *  - login as new user
 *  - when logged in
 *      - create new list item
 *      - option to define qty for item
 *      - flag to determine item in cart (bool)
 *      - delete item
 *      - update if item is in cart
 *  - persistent data
 */

public class App {
    public static void main( String[] args)
    {
        // Controller references
        UserController userCtrlr = new UserController();
        GroceryItemController grocCtrlr = new GroceryItemController();
        SessionController sessCtrlr = new SessionController();

        

        Javalin app = Javalin.create(config -> {
            // CLASSPATH references the 'resources' folder for maven
            config.addStaticFiles("/frontend", Location.CLASSPATH);
        }).start(9000);

        // Register endpoint
        app.post("/api/user", userCtrlr::register);

        // Session endpoints
        app.post("/api/session", sessCtrlr::login);
        app.delete("/api/session", sessCtrlr::logout);
        app.get("/api/session", sessCtrlr::checkSession);

        // Grocery item endpoints
        app.get("/api/item", grocCtrlr::getAllGroceryItemsGivenUID);
        app.post("/api/item", grocCtrlr::createItem);
        app.delete("/api/item", grocCtrlr::deleteItem);
        app.patch("/api/item", grocCtrlr::markItemComplete);
    }
}
