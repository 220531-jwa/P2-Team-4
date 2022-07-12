package dev.team4.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;
import dev.team4.services.TicketService;

@ExtendWith(MockitoExtension.class)

public class TicketServicesTests {

	
	
	@InjectMocks
	TicketService ticketServiceMocks;
     // private static TicketService ticketServiceMoks;
	
	@Mock
	TicketDAO ticketDaoMock;
	//private static TicketDAO ticketDaoMock;

	@Test
	public void SendRequestWithValidInput() {
// Given
		Ticket mockTicket = new Ticket(1, 1, 1, 1, 1, 1000);
		
// When
		when(ticketDaoMock.selectAllTicket(1, 1, 1, 1, 1, 1000))
			.thenReturn(mockTicket);
// Then
		Ticket ticketShowUp = ticketServiceMocks.selectAllTicket(1, 1, 1, 1, 1, 1000);

		assertEquals(mockTicket, ticketShowUp);


	}	
	
}
