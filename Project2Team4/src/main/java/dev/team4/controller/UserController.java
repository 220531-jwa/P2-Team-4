package dev.team4.controller;

import java.util.List;

import dev.team4.models.User;
import dev.team4.services.UserService;
import io.javalin.http.Context;

public class UserController {

	// USERSERVICE.JAVA CONNECTION
	private static UserService us;

	public UserController(UserService us) {
		UserController.us = us;
	}

	// LOGIN
	public void loginUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		User loggedInUser = us.login(u.getUserUserName(), u.getUserPassword());
		if (u != null && u.getAdmin() != true) {
			ctx.sessionAttribute("logged in customer", loggedInUser);
		} else if (u != null && u.getAdmin() == true) {
			ctx.sessionAttribute("logged in admin", loggedInUser);
		}
		ctx.json(loggedInUser);
	}

	// CREATE USER
	public void createUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		String userUserName = u.getUserUserName();
		String userPassword = u.getUserPassword();
		Boolean isAdmin = u.getAdmin();
		User check = null;
		try {
			check = us.createUser(userUserName, userPassword, isAdmin);
			if (check != null) {
				ctx.status(200);
				ctx.json(check);
			} else {
				ctx.status(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// GET ALL USERS
	public void getAllUsers(Context ctx) {
		ctx.status(200);
		List<User> u = us.getAllUsers();
		ctx.json(u);
	}

	// GET USER BY ID
	public void getUserById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = null;
		try {
			u = us.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(u);
	}

	// UPDATE PASSWORD
	public void updatePassword(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		User u = ctx.bodyAsClass(User.class);
		String userPassword = u.getUserPassword();
		User updated = us.updatePassword(id, userPassword);
		if (updated != null) {
			ctx.status(200);
			ctx.json(updated);
		} else {
			ctx.status(404);
		}
	}

	// DELETE USER
	public void deleteUser(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		us.deleteUser(id);
	}
}
