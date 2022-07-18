package dev.team4.unittests;

import dev.team4.models.Ticket;
import dev.team4.repo.TicketDAO;
import dev.team4.services.TicketService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllCustomersTicketTest {
    @InjectMocks
    private static TicketService ticketService;

    @Mock
    private static TicketDAO ticketDAO;

    @BeforeAll
    public void setup() {
        ticketService = new TicketService(ticketDAO);
    }

    @Test
    void getAllCustomerTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        int id = 3;
        when(ticketDAO.getAllCustomersTickets(id)).thenReturn(tickets);
        assertEquals(2, tickets.size());
    }
}
