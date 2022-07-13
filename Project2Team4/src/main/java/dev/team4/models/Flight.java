package dev.team4.models;

import java.sql.Time;

public class Flight {
	private int id;
	private String airline;
	private Time arriving;
	private Time departing;

	public Flight(int id, String airline, Time arriving, Time departing) {
		this.id = id;
		this.airline = airline;
		this.arriving = arriving;
		this.departing = departing;
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
	public Time getArriving() {
		return arriving;
	}

	public void setArriving(Time arriving) {
		this.arriving = arriving;
	}

	// DEPARTING
	public Time getDeparting() {
		return departing;
	}

	public void setDeparting(Time departing) {
		this.departing = departing;
	}

	// OVERDRIVE
	@Override
	public String toString() {
		return "User [id=" + id + ", airline=" + airline + ", arriving=" + arriving + ", departing=" + departing + "]";
	}
}
