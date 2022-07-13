package dev.driver;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import dev.team4.controller.FlightController;
import dev.team4.controller.FlightLocationController;
import dev.team4.controller.TicketController;
import dev.team4.controller.UserController;
import dev.team4.models.User;
import dev.team4.repo.FlightDAO;
import dev.team4.repo.FlightLocationDAO;
import dev.team4.repo.TicketDAO;
import dev.team4.repo.UserDAO;
import dev.team4.services.FlightLocationService;
import dev.team4.services.FlightService;
import dev.team4.services.TicketService;
import dev.team4.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

// CLASS NAME
public class MainDriver {

	// MAIN METHOD
	public static void main(String[] args) {

		// VARIABLES
		UserController uc = new UserController(new UserService(new UserDAO()));
		FlightController fc = new FlightController(new FlightService(new FlightDAO()));
		FlightLocationController flc = new FlightLocationController(new FlightLocationService(new FlightLocationDAO()));
		TicketController tc = new TicketController(new TicketService(new TicketDAO()));

		// JAVALIN
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		// URL NAME
		app.start(8030);

		// URL ROUTES
		app.routes(() -> {

			// CUSTOMER LOGIN
			path("/userlogin", () -> {
				post(uc::loginUser);
			});

			// ADMIN LOGIN
			path("/adminlogin", () -> {
				post(uc::loginUser);
			});

			// USER
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
					// UPDATE PASSWORD
					patch(uc::updatePassword);
					// DELETE USER
					delete(uc::deleteUser);
				});
			});

			// FLIGHT
			// http://localhost:8030/flight
			path("/flight", () -> {
				// CREATE FLIGHT
				post(fc::createFlight);
				// GET ALL FLIGHTS
				get(fc::getAllFlights);
				// http://localhost:8030/flight/3
				path("/{id}", () -> {
					// GET FLIGHT ID
					get(fc::getFlightById);
					// UPDATE AIRLINE
					patch(fc::updateAirline);
					// DELETE FLIGHT
					delete(fc::deleteFlight);
				});
			});

			// FLIGHT LOCATION
			// http://localhost:8030/flight_location
			path("/flight_location", () -> {
				// CREATE FLIGHT LOCATION
				post(flc::createFlightLocation);
				// GET ALL FLIGHT LOCATIONS
				get(flc::getAllFlightLocations);
				// http://localhost:8030/flight_location/3
				path("/{id}", () -> {
					// GET FLIGHT LOCATION ID
					get(flc::getFlightLocationById);
					// UPDATE DESCRIPTION
					patch(flc::updateDescription);
					// DELETE FLIGHT LOCATIONS
					delete(flc::deleteFlightLocation);
				});
			});

			// TICKET
			// http://localhost:8030/ticket
			path("/ticket", () -> {
				// CREATE TICKET
				post(tc::createTicket);
				// GET ALL TICKETS
				get(tc::getAllTickets);
				// http://localhost:8030/ticket/3
				path("/{id}", () -> {
					// GET TICKET ID
					get(tc::getTicketById);
					// UPDATE TICKET PRICE
					patch(tc::updateTicketPrice);
					// DELETE TICKET
					delete(tc::deleteTicket);
				});
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
