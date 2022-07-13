package dev.team4.models;

public class FlightLocation {

	int id;
	String city;
	String country;
	String description;

	public FlightLocation() {
	}

	public FlightLocation(int id, String city, String country, String description) {
		this.id = id;
		this.city = city;
		this.country = country;
		this.description = description;
	}

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// CITY
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// COUNTRY
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	// DESCRIPTION
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FlightLocation [id = " + id + ", city = " + city + ", country = " + country + ", description = "
				+ description + "]";
	}
}