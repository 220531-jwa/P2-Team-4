package dev.team4.controller;

import dev.team4.models.Flight;
import dev.team4.services.FlightService;
import io.javalin.http.Context;

public class FlightController {
    private static final FlightService flightService = new FlightService();

    public static void createFlight(Context ctx) {
        Flight flight = ctx.bodyAsClass(Flight.class);

        Flight result = flightService.createFlight(flight);

        if (result != null) {
            ctx.status(201);
            ctx.json(result);
        } else {
            ctx.status(422);
        }
    }
}
