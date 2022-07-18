package dev.team4.services;


import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;

import java.util.List;

public class TicketService {

    private static TicketDAO td;

    public TicketService(TicketDAO td) {
        this.td = td;
    }

    public boolean buyTicket(Ticket t) {
        return td.buyTicket(t);
    }

    public boolean deleteTicket(int id) {
        return td.deleteTicket(id);
    }

    // select all Ticket
    public List<Ticket> selectAllTicket() {

        return td.selectAllTicket();
    }

    public boolean setDiscountAtFlight(Ticket t) {
		return td.updatePriceTicket(t);
	}

    public List<Ticket> getAllCustomersTickets(int id) {
        return td.getAllCustomersTickets(id);
    }
}
