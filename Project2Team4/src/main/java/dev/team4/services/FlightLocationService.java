package dev.team4.services;

import dev.team4.models.FlightLocation;
import dev.team4.repo.FlightLocationDAO;

public class FlightLocationService 
{
	private static FlightLocationDAO fld;
	
	public FlightLocationService(FlightLocationDAO fld)
	{
		this.fld = fld;
	}
	public boolean updateFlightDescription(FlightLocation f)
	{
		return fld.updateDescription(f);
	}

}
