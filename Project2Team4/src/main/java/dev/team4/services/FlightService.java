package dev.team4.services;

import dev.team4.models.Flight;
import dev.team4.repo.FlightDAO;

public class FlightService {
    private FlightDAO flightDAO = new FlightDAO();

    public Flight createFlight(Flight flight) {
        if (flight.getAirline().equals("") || flight.getArriving() == null || flight.getDeparting() == null) {
            return null;
        }
        return flightDAO.createFlight(flight);
    }

    public Flight getFlightById(int id) {
        return flightDAO.getFlightById(id);
    }
}
