package dev.team4.services;

import java.util.List;

import dev.team4.models.FlightLocation;
import dev.team4.repo.FlightLocationDAO;

public class FlightLocationService {

	// FlightLocationDAO.java CONNECITON
	private static FlightLocationDAO fld;

	public FlightLocationService(FlightLocationDAO fld) {
		FlightLocationService.fld = fld;
	}

	// CREATE FLIGHT LOCATION
	public FlightLocation createFlightLocation(String city, String country, String description) {
		return fld.createFlightLocation(city, country, description);
	}

	// GET ALL FLIGHT LOCATIONS
	public List<FlightLocation> getAllFlightLocations() {
		return fld.getAllFlightLocations();
	}

	// GET FLIGHT LOCATION ID
	public FlightLocation getFlightLocationById(int id) throws Exception {
		FlightLocation fl = fld.getFlightLocationById(id);

		if (fld == null) {
			throw new Exception("Flight Location not found");
		}
		return fl;
	}

	// UPDATE DESCRIPTION
	public boolean updateDescription(FlightLocation f) {
		return fld.updateDescription(f);
	}

//	public FlightLocation updateDescription(int id, String description, FlightLocation mock) {
//		return fld.updateDescription(id, description);
//	}

	// DELETE FLIGHT LOCATION
	public void deleteFlightLocation(int id) {
		fld.deleteFlightLocation(id);
	}
}