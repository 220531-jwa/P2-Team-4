package dev.team4.controller;

import dev.team4.models.User;
import dev.team4.services.UserService;
import io.javalin.http.Context;

public class UserController {

	// USERSERVICE.JAVA CONNECTION
	private UserService us;

	public UserController(UserService us) {
		this.us = us;
	}

	// LOGIN
	public void loginUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		User loggedInUser = us.login(u.getUsername(), u.getPass());
		if (u != null && u.isAdmin() != true) {
			ctx.sessionAttribute("logged in customer", loggedInUser);
		} else if (u != null && u.isAdmin() == true) {
			ctx.sessionAttribute("logged in admin", loggedInUser);
		}
		ctx.json(loggedInUser);
	}
}
