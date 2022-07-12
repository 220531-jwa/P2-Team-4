package dev.team4.controller;

import dev.team4.models.Ticket;
import dev.team4.services.TicketService;
import io.javalin.http.Context;

public class TicketController 
{
	private static TicketService ts;
	
	public TicketController(TicketService ts)
	{
		this.ts = ts;
	}

	public void buyTicket(Context ctx)
	{
		Ticket t = ctx.bodyAsClass(Ticket.class);
		
		System.out.println(" " + ctx.sessionAttribute("id"));
		
		t.setCustomer_id(ctx.sessionAttribute("id"));
		
		System.out.println(" " + t.getCustomer_id());
		
		boolean success = ts.buyTicket(t);
		try {
			
			if(!success)
			{
				ctx.status(404);
			} else {
				ctx.status(200);
				ctx.json(t);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
