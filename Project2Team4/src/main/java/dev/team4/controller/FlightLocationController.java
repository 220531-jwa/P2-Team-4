package dev.team4.controller;

import java.util.List;

import dev.team4.models.FlightLocation;
import dev.team4.services.FlightLocationService;
import io.javalin.http.Context;

public class FlightLocationController {

	// FlightLocationService.java CONNECTION
	private static FlightLocationService fls;

	public FlightLocationController(FlightLocationService fls) {
		FlightLocationController.fls = fls;
	}

	// CREATE FLIGHT LOCATION
	public void createFlightLocation(Context ctx) {
		FlightLocation fl = ctx.bodyAsClass(FlightLocation.class);
		String city = fl.getCity();
		String country = fl.getCountry();
		String description = fl.getDescription();
		FlightLocation check = null;
		try {
			check = fls.createFlightLocation(city, country, description);
			if (check != null) {
				ctx.status(200);
				ctx.json(check);
			} else {
				ctx.status(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// GET ALL FLIGHT LOCATIONS
	public void getAllFlightLocations(Context ctx) {
		ctx.status(200);
		List<FlightLocation> fl = fls.getAllFlightLocations();
		ctx.json(fl);
	}

	// GET FLIGHT LOCATION BY ID
	public void getFlightLocationById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		FlightLocation fl = null;
		try {
			fl = fls.getFlightLocationById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.status(200);
		ctx.json(fl);
	}

	// UPDATE DESCRIPTION
	public void updateDescription(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		FlightLocation fl = ctx.bodyAsClass(FlightLocation.class);
		String description = fl.getDescription();
		FlightLocation updated = fls.updateDescription(id, description);
		if (updated != null) {
			ctx.status(200);
			ctx.json(updated);
		} else {
			ctx.status(404);
		}
	}

	// DELETE FLIGHT LOCATION
	public void deleteFlightLocation(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		fls.deleteFlightLocation(id);
	}
}
