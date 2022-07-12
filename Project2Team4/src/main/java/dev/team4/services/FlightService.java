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
	public Flight createFlight(int id, String airline, String arriving, String departing) {
		return fd.createFlight(id, airline, arriving, departing);
	}

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

	// UPDATE FLIGHT
	public Flight updateFlight(int id, String airline, String arriving, String departing) {
		return fd.updateFlight(id, airline, arriving, departing);
	}

	// DELETE FLIGHT
	public void deleteFlight(int id) {
		fd.deleteFlight(id);
	}
}