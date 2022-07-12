package dev.team4.controller;

import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.services.TicketService;
import io.javalin.http.Context;

public class TicketController {

	
	private TicketService ts;


	public TicketController(TicketService ts) {
		this.ts = ts;
	}
	

	//==============
	// select all Ticket
	public void selectAllTicket(Context ctx) {
		ctx.status(200);
	    List<Ticket> tickets = ts.selectAllTicket();
		ctx.json(tickets);
}
	
}
