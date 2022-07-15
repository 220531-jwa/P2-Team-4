package dev.team4.models;

import java.sql.Time;

public class Flight {
	private int id;
	private String airline;
	private Time arrival;
	private Time departure;

	public Flight(int id, String airline, Time arrival, Time departure) {
		this.id = id;
		this.airline = airline;
		this.arrival = arrival;
		this.departure = departure;
	}

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// AIRLINE
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	// ARRIVING
	public Time getArrival() {
		return arrival;
	}

	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}

	// DEPARTING
	public Time getDeparture() {
		return departure;
	}

	public void setDeparture(Time departure) {
		this.departure = departure;
	}

	// OVERDRIVE
	@Override
	public String toString() {
		return "User [id=" + id + ", airline=" + airline + ", arrival=" + arrival + ", departure=" + departure + "]";
	}
}
