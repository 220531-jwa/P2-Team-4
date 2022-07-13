// PACKAGE
package dev.team4.unittests;

//IMPORTS
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team4.models.Flight;
import dev.team4.repo.FlightDAO;
import dev.team4.services.FlightService;

//MOCKITO EXTENSION
@ExtendWith(MockitoExtension.class)

//CLASS
public class AdminCreateFlightTests {

	// MOCK WITH FlightService.java
	@InjectMocks
	private static FlightService mockFlightService;

	// MOCK WITH FlightDAO.java
	@Mock
	private static FlightDAO mockFlightDAO;

	// CREATE FLIGHT
	@Test
	void testCreateFlight() {
		Flight testFlight = new Flight(1, "United", LocalTime.parse("06:00"), LocalTime.parse("18:30"));
		when(mockFlightDAO.createFlight(testFlight)).thenReturn(testFlight);
		assertEquals(testFlight.getId(), mockFlightService.createFlight(testFlight).getId());
	}

	// CREATE FLIGHT FAILED
	@Test
	void testFailedCreateFlight() {
		Flight testFlight = new Flight(2, "Delta", null, null);
		assertEquals(null, mockFlightService.createFlight(testFlight));
	}
}