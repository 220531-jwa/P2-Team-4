package dev.team4.services;

import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;

public class TicketService {

	// TICKETDAO.JAVA CONNECITON
	private static TicketDAO td;

	public TicketService(TicketDAO td) {
		TicketService.td = td;
	}

	// CREATE TICKET
	public Ticket createTicket(int customer_id, int flight_id, int origin_id, int destination_id, int price) {
		return td.createTicket(customer_id, flight_id, origin_id, destination_id, price);
	}

	// GET ALL TICKETS
	public List<Ticket> getAllTickets() {
		return td.getAllTickets();
	}

	// GET TICKET ID
	public Ticket getTicketById(int id) throws Exception {
		Ticket t = td.getTicketById(id);

		if (t == null) {
			throw new Exception("User not found");
		}
		return t;
	}

	// UPDATE TICKET PRICE
	public Ticket updateTicketPrice(int id, int price) {
		return td.updateTicketPrice(id, price);
	}

	// DELETE TICKET
	public void deleteTicket(int id) {
		td.deleteTicket(id);
	}

	// BUY TICKET
	public boolean buyTicket(Ticket t) {
		return td.buyTicket(t);
	}
}