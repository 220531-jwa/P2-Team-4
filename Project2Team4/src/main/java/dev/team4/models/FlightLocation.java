package dev.team4.models;

public class FlightLocation 
{
	
	int flightId;
	String flightDescription;
	String flightCountry;
	String flightCity;
	public FlightLocation()
	{
		
	}
	public FlightLocation(int flightId, String flightDescription, String flightCountry, String flightCity) 
	{
		this.flightId = flightId;
		this.flightDescription = flightDescription;
		this.flightCountry = flightCountry;
		this.flightCity = flightCity;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightDescription() {
		return flightDescription;
	}
	public void setFlightDescription(String flightDescription) {
		this.flightDescription = flightDescription;
	}
	public String getFlightCountry() {
		return flightCountry;
	}
	public void setFlightCountry(String flightCountry) {
		this.flightCountry = flightCountry;
	}
	public String getFlightCity() {
		return flightCity;
	}
	public void setFlightCity(String flightCity) {
		this.flightCity = flightCity;
	}
	@Override
	public String toString() 
	{
		return "FlightLocation [flightId=" + flightId + ", flightDescription=" + flightDescription + ", flightCountry="
				+ flightCountry + ", flightCity=" + flightCity + "]";
	}
	
	
	
	

}
