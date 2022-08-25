package com.revature.controllers;
import com.revature.models.JsonResponse;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Context;

public class UserController {
    UserService us = new UserService();

    // need to register acct
    public void register(Context ctx){
        User creds = ctx.bodyAsClass(User.class);
        
        // use this func to check if creds exists as a user in DB
        //  if it does, returns null
        //  else creates user & returns that user obj
        User userFromDB = us.createUser(creds);

        if(userFromDB == null){
            ctx.json(new JsonResponse(false, "username already exists in system", null));
        }else{
            ctx.json(new JsonResponse(true, "user created", userFromDB));
        }
    }
}
