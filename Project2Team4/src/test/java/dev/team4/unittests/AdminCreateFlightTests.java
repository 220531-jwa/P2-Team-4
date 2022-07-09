package dev.team4.unittests;

import dev.team4.models.Flight;
import dev.team4.repo.UserDAO;
import dev.team4.services.UserService;
import org.junit.jupiter.api.BeforeEach;
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
    private static UserService mockUserService;

    @Mock
    private static UserDAO mockUserDAO;

    @BeforeEach
    void setupEach() {
        mockUserService = new UserService(mockUserDAO);
    }

    @Test
    void testCreateFlight() {
        Flight testFlight = new Flight(1, "United", LocalTime.parse("06:00"), LocalTime.parse("18:30"));
        when(mockUserDAO.createFlight(testFlight)).thenReturn(testFlight);
        assertEquals(testFlight, mockUserService.createFlight(testFlight));
    }

    @Test
    void testFailedCreateFlight() {
        Flight testFlight = new Flight(2, "Delta", null, null);
        assertEquals(null, mockUserService.createFlight(testFlight));
    }

    @Test
    void testActualDAO() {
        UserService userService = new UserService(new UserDAO());
        Flight testFlight = new Flight(1, "United", LocalTime.parse("06:00"), LocalTime.parse("18:30"));
        assertEquals(testFlight.getAirline(), userService.createFlight(testFlight).getAirline());
        assertEquals(testFlight.getArriving(), userService.createFlight(testFlight).getArriving());
        assertEquals(testFlight.getDeparting(), userService.createFlight(testFlight).getDeparting());
    }
}
