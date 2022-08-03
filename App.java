package com.revature;

import com.revature.models.User;
import com.revature.store.Store;
import com.revature.consoleviews.MainMenu;

/**
 * Grocery List
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
public class App 
{
    public static void main( String[] args)
    {
        // Create Mainmenu object, then call the view() to start the program
        MainMenu mainmenu = new MainMenu();
        mainmenu.view();
    }
}
