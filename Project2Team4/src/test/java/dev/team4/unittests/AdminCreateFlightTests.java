package dev.team4.unittests;

import dev.team4.models.Flight;
import dev.team4.repo.FlightDAO;
import dev.team4.services.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminCreateFlightTests {
    @InjectMocks
    private static FlightService mockFlightService;

    @Mock
    private static FlightDAO mockFlightDAO;

    @Test
    void testCreateFlight() {
        Flight testFlight = new Flight(1, "United", LocalTime.parse("06:00"), LocalTime.parse("18:30"));
        when(mockFlightDAO.createFlight(testFlight)).thenReturn(testFlight);
        assertEquals(testFlight.getId(), mockFlightService.createFlight(testFlight).getId());
    }

    @Test
    void testFailedCreateFlight() {
        Flight testFlight = new Flight(2, "Delta", null, null);
        assertEquals(null, mockFlightService.createFlight(testFlight));
    }
}
