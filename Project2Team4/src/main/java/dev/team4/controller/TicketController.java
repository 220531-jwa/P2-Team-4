package dev.team4.controller;

import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.services.TicketService;
import io.javalin.http.Context;

public class TicketController {

	// TICKETSERVICE.JAVA CONNECTION
	private static TicketService ts;

	public TicketController(TicketService ts) {
		TicketController.ts = ts;
	}

	// CREATE TICKET
	public void createTicket(Context ctx) {
		Ticket t = ctx.bodyAsClass(Ticket.class);
		int customer_id = t.getCustomer_id();
		int flight_id = t.getFlight_id();
		int origin_id = t.getOrigin_id();
		int destination_id = t.getDestination_id();
		int price = t.getPrice();
		Ticket check = null;
		try {
			check = ts.createTicket(customer_id, flight_id, origin_id, destination_id, price);
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

	// GET ALL TICKETS
	public void getAllTickets(Context ctx) {
		ctx.status(200);
		List<Ticket> t = ts.getAllTickets();
		ctx.json(t);
	}

	// GET TICKET BY ID
	public void getTicketById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Ticket u = null;
		try {
			u = ts.getTicketById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(u);
	}

	// UPDATE TICKET PRICE
	public void updateTicketPrice(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Ticket t = ctx.bodyAsClass(Ticket.class);
		int price = t.getPrice();
		Ticket updated = ts.updateTicketPrice(id, price);
		if (updated != null) {
			ctx.status(200);
			ctx.json(updated);
		} else {
			ctx.status(404);
		}
	}

	// DELETE TICKET
	public void deleteTicket(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		ts.deleteTicket(id);
	}
}
