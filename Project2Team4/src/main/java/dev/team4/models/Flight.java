package dev.team4.models;

import java.time.LocalTime;

public class Flight {
    private int id;
    private String airline;
    private LocalTime arriving;
    private LocalTime departing;

    public Flight(int id, String airline, LocalTime arriving, LocalTime departing) {
        this.id = id;
        this.airline = airline;
        this.arriving = arriving;
        this.departing = departing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public LocalTime getArriving() {
        return arriving;
    }

    public void setArriving(LocalTime arriving) {
        this.arriving = arriving;
    }

    public LocalTime getDeparting() {
        return departing;
    }

    public void setDeparting(LocalTime departing) {
        this.departing = departing;
    }
}

