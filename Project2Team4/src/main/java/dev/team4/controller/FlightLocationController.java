package dev.team4.controller;

import dev.team4.models.FlightLocation;
import dev.team4.models.Ticket;
import dev.team4.services.FlightLocationService;
import io.javalin.http.Context;

public class FlightLocationController 
{
	private static FlightLocationService fs;
	
	public FlightLocationController(FlightLocationService fs)
	{
		this.fs = fs;
	}
	
	public void updateFlightDescription(Context ctx)
	{
		FlightLocation f = ctx.bodyAsClass(FlightLocation.class);
		
		boolean success = fs.updateFlightDescription(f);
		try {
			
			if(!success)
			{
				ctx.status(404);
			} else {
				ctx.status(200);
				ctx.json(f);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
