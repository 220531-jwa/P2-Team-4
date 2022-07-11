package dev.team4.controller;

import java.util.List;

import dev.team4.models.Flight;
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
		ctx.status(201);
		User userFromRequestBody = ctx.bodyAsClass(User.class);
		User u = us.createUser(userFromRequestBody);
		ctx.json(u);
	}

	// CREATE FLIGHT
	public void createFlight(Context ctx) {
		Flight flight = ctx.bodyAsClass(Flight.class);
		Flight result = us.createFlight(flight);
		if (result != null) {
			// SUCCESS
			ctx.status(201);
			ctx.json(result);
		} else {
			// FAILURE
			ctx.status(422);
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

	// GET USERNAME
	public void getUserByUserName(Context ctx) {
		String userUserName = (ctx.pathParam("userUserName"));
		User u = null;
		try {
			u = us.getUserByUserName(userUserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(u);
	}

	// UPDATE USER
	public void updateUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		boolean success = us.updateUser(u);
		try {
			if (!success) {
				ctx.status(404);
			} else {
				ctx.status(200);
				ctx.json(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DELETE USER
	public void deleteUser(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		us.deleteUser(id);
	}
}
