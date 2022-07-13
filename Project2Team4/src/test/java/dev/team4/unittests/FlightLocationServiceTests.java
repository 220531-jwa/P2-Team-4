package dev.team4.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team4.models.FlightLocation;
import dev.team4.repo.FlightLocationDAO;
import dev.team4.services.FlightLocationService;

@ExtendWith(MockitoExtension.class)
public class FlightLocationServiceTests {
	@InjectMocks
	private static FlightLocationService mockFls;

	@Mock
	private static FlightLocationDAO mockFld;

	@BeforeEach
	public void setupEach() {
		mockFls = new FlightLocationService(mockFld);
	}

	// CORRECT ADMIN CREDENTIALS
	@Test
	public void adminInputCorrectId() {
		// GIVEN
		FlightLocation mock = new FlightLocation(1, "Jamaica living the life", "Jamaica", "Kingston");
		// WHEN
		when(mockFld.updateDescription(mock)).thenReturn(true);
		// THEN
		assertEquals(true, mockFls.updateDescription(mock));
	}

	// WRONG ADMIN CREDENTIALS
	@Test
	public void adminInputIncorrectId() {
		// GIVEN
		FlightLocation mock = new FlightLocation(0, "Jamaica living the life", "Jamaica", "Kingston");
		// WHEN
		when(mockFld.updateDescription(mock)).thenReturn(false);
		// THEN
		assertEquals(false, mockFls.updateDescription(mock));
	}
}