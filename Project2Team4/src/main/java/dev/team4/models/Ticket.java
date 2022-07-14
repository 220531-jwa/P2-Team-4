package dev.team4.models;


public class Ticket 
{ 

	int id;
	int flight_id;
	int customer_id;
	int destination_id;
	int origin_id;
	int price;

	public Ticket() {
		
	}
	public Ticket(int id, int flight_id, int customer_id, int destination_id, int origin_id, int price) 
	{

		super();
		this.id = id;
		this.flight_id = flight_id;
		this.customer_id = customer_id;
		this.destination_id = destination_id;
		this.origin_id = origin_id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getDestination_id() {
		return destination_id;
	}
	public void setDestination_id(int destination_id) {
		this.destination_id = destination_id;
	}
	public int getOrigin_id() {
		return origin_id;
	}
	public void setOrigin_id(int origin_id) {
		this.origin_id = origin_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {

		return "Ticket [id=" + id + ", flight_id=" + flight_id + ", customer_id=" + customer_id + ", destination_id="
				+ destination_id + ", origin_id=" + origin_id + ", price=" + price + "]";
	}


}
