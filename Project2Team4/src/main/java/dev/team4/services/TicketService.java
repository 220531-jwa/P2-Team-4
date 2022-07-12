package dev.team4.services;

import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;



public class TicketService {

	
	private static TicketDAO ticketDao;
	
	public TicketService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	

// select all Ticket
		public List<Ticket> selectAllTicket() {
			
		return ticketDao.selectAllTicket();
		}
	
}
