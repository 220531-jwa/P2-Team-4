package dev.team4.unittests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;
import dev.team4.services.TicketService;
import dev.team4.services.UserService;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTests 
{
	@InjectMocks
	private static TicketService tsMocks;
	
	@Mock
	private static TicketDAO mockTd;
	
	@BeforeEach
	public void setupEach()
	{
		tsMocks = new TicketService(mockTd);
	}
	
	@Test
	public void customerBoughtTicket()
	{
		//Given
		Ticket mock = new Ticket(1, 2, 1, 3, 1, 100);
		//When
		when(mockTd.buyTicket(mock)).thenReturn(true);
		//Then
		assertEquals(true, tsMocks.buyTicket(mock));
	}
	
	@Test
	public void ticketNotFound()
	{
		Ticket mock = new Ticket(0, 2, 1, 3, 1, 200);
		
		when(mockTd.buyTicket(mock)).thenReturn(false);
		
		assertEquals(false, tsMocks.buyTicket(mock));
	}

}
