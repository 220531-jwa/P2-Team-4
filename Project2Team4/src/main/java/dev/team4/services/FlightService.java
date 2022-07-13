package dev.team4.services;

import java.util.List;

import dev.team4.models.Flight;
import dev.team4.repo.FlightDAO;

public class FlightService {

	// FLIGHTDAO.JAVA CONNECITON
	private static FlightDAO fd;

	public FlightService(FlightDAO fd) {
		FlightService.fd = fd;
	}

	// CREATE FLIGHT
	public Flight createFlight(Flight flight) {
		if (flight.getAirline().equals("") || flight.getArriving() == null || flight.getDeparting() == null) {
			return null;
		}
		return fd.createFlight(flight);
	}
//	public Flight createFlight(String airline, String arriving, String departing) {
//		return fd.createFlight(airline, arriving, departing);
//	}

	// GET ALL FLIGHTS
	public List<Flight> getAllFlights() {
		return fd.getAllFlights();
	}

	// GET FLIGHT ID
	public Flight getFlightById(int id) throws Exception {
		Flight f = fd.getFlightById(id);
		if (f == null) {
			throw new Exception("Flight not found");
		}
		return f;
	}

	// UPDATE AIRLINE
	public Flight updateAirline(int id, String airline) {
		return fd.updateAirline(id, airline);
	}

	// DELETE FLIGHT
	public void deleteFlight(int id) {
		fd.deleteFlight(id);
	}
}