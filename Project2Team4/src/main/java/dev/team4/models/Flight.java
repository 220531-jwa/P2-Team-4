package dev.team4.models;

public class Flight {
	private int id;
	private String airline;
	private String arriving;
	private String departing;

	public Flight(int id, String airline, String arriving, String departing) {
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
	public String getArriving() {
		return arriving;
	}

	public void setArriving(String arriving) {
		this.arriving = arriving;
	}

	// DEPARTING
	public String getDeparting() {
		return departing;
	}

	public void setDeparting(String departing) {
		this.departing = departing;
	}

	// OVERDRIVE
	@Override
	public String toString() {
		return "User [id=" + id + ", airline=" + airline + ", arriving=" + arriving + ", departing=" + departing + "]";
	}
}
