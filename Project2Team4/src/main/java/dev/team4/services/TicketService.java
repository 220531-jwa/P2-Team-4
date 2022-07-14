package dev.team4.services;


import java.util.List;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;

public class TicketService 
{
	
	private static TicketDAO td;

	public TicketService(TicketDAO td)
	{
		this.td = td;
	}
	
	public boolean buyTicket(Ticket t)
	{
		return td.buyTicket(t);
	}
	
	public boolean deleteTicket(int id) 
	{
		return td.deleteTicket(id);
	}
  
	public List<Ticket> selectAllTicket() 
	{
		
	return td.selectAllTicket();
	}
}
