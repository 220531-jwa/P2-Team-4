package dev.driver;

import dev.team4.controller.TicketController;
import dev.team4.controller.UserController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import dev.team4.repo.TicketDAO;
import dev.team4.repo.UserDAO;
import dev.team4.models.User;
import dev.team4.services.TicketService;
import dev.team4.services.UserService;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

public class MainDriver 
{
	
	public static void main(String[] args)
	{
		
		UserController uc = new UserController(new UserService(new UserDAO()));
		TicketController tc = new TicketController(new TicketService(new TicketDAO()));
		
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		
		app.start(8020);
		
		app.routes(() -> 
		{
			path("/userlogin", () ->
			{
				post(uc::loginUser);
				put(tc::buyTicket);
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
