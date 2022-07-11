package dev.driver;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import dev.team4.controller.UserController;
import dev.team4.models.User;
import dev.team4.repo.UserDAO;
import dev.team4.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainDriver {

	public static void main(String[] args) {

		UserController uc = new UserController(new UserService(new UserDAO()));
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		app.start(8030);

		app.routes(() -> {

			// USER
			path("/userlogin", () -> {
				// LOGIN
				post(uc::loginUser);
			});

			// http://localhost:8030/user
			path("/user", () -> {
				// CREATE USER
				post(uc::createUser);
				// GET ALL USERS
				get(uc::getAllUsers);

				// http://localhost:8030/user/3
				path("/{id}", () -> {
					// GET USER ID
					get(uc::getUserById);
					// UPDATE USER
					patch(uc::updateUser);
					// DELETE USER
					delete(uc::deleteUser);
				});

				// http://localhost:8030/user/andy
				path("/{username}", () -> {
					// GET USERNAME
					get(uc::getUserByUserName);
				});
			});

			// ADMIN
			path("/adminlogin", () -> {
				post(uc::loginUser);
			});

			// FLIGHT
			path("/flight", () -> {
				post(uc::createFlight);
			});

			// SESSION
			path("/getSession", () -> {
				get(ctx -> {
					// LOGGED IN
					User loggedInUser = ctx.sessionAttribute("loggedInUser");
					System.out.println(loggedInUser);
				});
			});

		});
	}
}
