package dev.driver;

import static io.javalin.apibuilder.ApiBuilder.get;
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
