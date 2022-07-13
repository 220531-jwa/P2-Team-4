package dev.team4.controller;

import java.util.List;

import dev.team4.models.Flight;
import dev.team4.services.FlightService;
import io.javalin.http.Context;

public class FlightController {

	// FLIGHTSERVICE.JAVA CONNECTION
	private static FlightService fs;

	public FlightController(FlightService fs) {
		FlightController.fs = fs;
	}

	// CREATE FLIGHT
	public static void createFlight(Context ctx) {
		Flight flight = ctx.bodyAsClass(Flight.class);
		Flight result = fs.createFlight(flight);
		if (result != null) {
			ctx.status(201);
			ctx.json(result);
		} else {
			ctx.status(422);
		}
	}
//	public void createFlight(Context ctx) {
//		Flight f = ctx.bodyAsClass(Flight.class);
//		String airline = f.getAirline();
//		Time arriving = f.getArriving();
//		Time departing = f.getDeparting();
//		Flight check = null;
//		try {
//			check = fs.createFlight(airline, arriving, departing);
//			if (check != null) {
//				ctx.status(200);
//				ctx.json(check);
//			} else {
//				ctx.status(404);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// GET ALL FLIGHTS
	public void getAllFlights(Context ctx) {
		ctx.status(200);
		List<Flight> f = fs.getAllFlights();
		ctx.json(f);
	}

	// GET FLIGHTS BY ID
	public void getFlightById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Flight f = null;
		try {
			f = fs.getFlightById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(f);
	}

	// UPDATE AIRLINE
	public void updateAirline(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Flight f = ctx.bodyAsClass(Flight.class);
		String airline = f.getAirline();
		Flight updated = fs.updateAirline(id, airline);
		if (updated != null) {
			ctx.status(200);
			ctx.json(updated);
		} else {
			ctx.status(404);
		}
	}

	// DELETE FLIGHTS
	public void deleteFlight(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		fs.deleteFlight(id);
	}
}
