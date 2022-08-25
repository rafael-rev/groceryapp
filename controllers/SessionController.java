package com.revature.controllers;

import com.revature.models.JsonResponse;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Context;

public class SessionController {
    // references to SERVICE LAYER
    UserService userSvc = new UserService();

    public void login(Context ctx){
        // store the input creds
        User creds = ctx.bodyAsClass(User.class);

        // Validate creds
        if(userSvc.validateCreds(creds)==true){
            // grab user from DB based on given creds username
            User userFromDB = userSvc.getUserGivenUsername(creds.getUsername());
            // set the session
            ctx.sessionAttribute("user", userFromDB);
            // return response
            ctx.json(new JsonResponse(true, "login successful",userFromDB));
        }else{
            // wrong creds info
            ctx.json(new JsonResponse(false, "invalid creds", null));
        }
    }

    public void logout(Context ctx){
        // set session value to null, erasing the session
        ctx.sessionAttribute("user", null);
        ctx.json(new JsonResponse(true, "logout successful", null));
    }

    public void checkSession(Context ctx){
        User user = ctx.sessionAttribute("user");

        if(user == null){
            ctx.json(new JsonResponse(false, "no session found", null));
        }else{
            ctx.json(new JsonResponse(true, "session found", user));
        }
    }
}
