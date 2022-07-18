package dev.driver;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import dev.team4.controller.FlightController;
import dev.team4.controller.FlightLocationController;
import dev.team4.controller.TicketController;
import dev.team4.controller.UserController;
import dev.team4.models.User;
import dev.team4.repo.FlightLocationDAO;
import dev.team4.repo.TicketDAO;
import dev.team4.repo.UserDAO;
import dev.team4.services.FlightLocationService;
import dev.team4.services.TicketService;
import dev.team4.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainDriver {

	public static void main(String[] args) {

		UserController uc = new UserController(new UserService(new UserDAO()));
		TicketController tc = new TicketController(new TicketService(new TicketDAO()));
		FlightLocationController flc = new FlightLocationController(new FlightLocationService(new FlightLocationDAO()));

		Javalin app = Javalin.create(config -> {

			config.enableCorsForAllOrigins();
			// config.enableCorsForOrigin("http://team4-s3-static-hosting.s3-website-us-east-1.amazonaws.com");
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		app.start(8030);

		app.routes(() -> {
			path("/userlogin", () -> {
				post(uc::loginUser);
				put(tc::buyTicket);
				path("/tickets", () -> {
					get(tc::selectAllTicket);
					put(tc::setDiscountAtFlight);
				});

				path("/adminupdatedescription", () -> {
					put(flc::updateFlightDescription);
				});

				// path("/adminupdateprice", () -> {put(tc::setDiscountAtFlight);});

				path("/cancelticket", () -> {
					delete(tc::deleteTicket);
				});
			});

			path("/flight", () -> {
				post(FlightController::createFlight);
			});

			path("/getSession", () -> {
				get(ctx -> {
					User loggedInUser = ctx.sessionAttribute("loggedInUser");

					System.out.println(loggedInUser);
				});
			});

		});

//        app.delete("userlogin/cancelticket", (ctx) ->
//        {
//
//        });

	}

}
