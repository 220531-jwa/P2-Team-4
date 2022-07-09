package dev.team4.controller;

import dev.team4.models.Flight;
import dev.team4.models.User;
import dev.team4.services.UserService;
import io.javalin.http.Context;

public class UserController {

    private UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    public void loginUser(Context ctx) {
        User u = ctx.bodyAsClass(User.class);

        User loggedInUser = us.login(u.getUserUserName(), u.getUserPassword());

        if (u != null && u.isAdmin() != true) {
            ctx.sessionAttribute("logged in customer", loggedInUser);
        } else if (u != null && u.isAdmin() == true) {
            ctx.sessionAttribute("logged in admin", loggedInUser);
        }

        ctx.json(loggedInUser);
    }


    public void createFlight(Context ctx) {
        Flight flight = ctx.bodyAsClass(Flight.class);

        Flight result = us.createFlight(flight);

        if (result != null) {
            ctx.status(201);
            ctx.json(result);
        } else {
            ctx.status(422);
        }
    }
}
