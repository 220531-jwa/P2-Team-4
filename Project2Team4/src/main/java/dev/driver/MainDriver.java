package dev.driver;

import dev.team4.controller.FlightLocationController;
import dev.team4.controller.TicketController;
import dev.team4.controller.UserController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import dev.team4.repo.FlightLocationDAO;
import dev.team4.repo.TicketDAO;
import dev.team4.repo.UserDAO;
import dev.team4.models.User;
import dev.team4.services.FlightLocationService;
import dev.team4.controller.FlightController;
import dev.team4.controller.TicketController;
import dev.team4.controller.UserController;
import dev.team4.models.User;
import dev.team4.repo.TicketDAO;
import dev.team4.repo.UserDAO;
import dev.team4.services.TicketService;
import dev.team4.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.*;

public class MainDriver {

    public static void main(String[] args) {

        UserController uc = new UserController(new UserService(new UserDAO()));
        TicketController tc = new TicketController(new TicketService(new TicketDAO()));
        FlightLocationController flc = new FlightLocationController(new FlightLocationService(new FlightLocationDAO()));
        
        Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			//config.enableCorsForOrigin("http://team4-s3-static-hosting.s3-website-us-east-1.amazonaws.com");
			config.addStaticFiles("/public", Location.CLASSPATH);
		});


        app.start(8040);

        app.routes(() ->
        {
            path("/userlogin", () ->
            {
                post(uc::loginUser);
                put(tc::buyTicket);
                
                path("/adminupdatedescription", () -> 
				{
					put(flc::updateFlightDescription);
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


    }
}
