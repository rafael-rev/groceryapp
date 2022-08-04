package com.revature;

import com.revature.consoleviews.MainMenu;
import com.revature.util.*;
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
public class App 
{
    public static void main( String[] args)
    // {
    //     // Create Mainmenu object, then call the view() to start the program
    //     MainMenu mainmenu = new MainMenu();
    //     mainmenu.view();
    // }
    {
        InputUtil input = new InputUtil();
        Integer num = input.retrieveInt("Enter a number plx: ");
        System.out.println(num);
    }
}
