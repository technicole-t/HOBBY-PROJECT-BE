package com.example.demo.persistence.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Journey {
	
	@Id
	@GeneratedValue
	@Column(name="journey_id", unique = true)
	private Long id; 
	
	@Column(name="depature_airport", length = 60, nullable = false)
	private String departureAirport; 
	
	@Column(name="destination_airport", length = 60, nullable = false)
	private String destinationAirport; 
	
	@Column(name="mode_of_travel", length = 20)
	private String modeOfTravel; 
	
	@Column(name="date_of_journey")
	private LocalDate date; 
	
	@JoinColumn(name = "trip_id")
	@ManyToOne(targetEntity = Trip.class)
	private Trip trip;

	public Journey(Long id, String departureAirport, String destinationAirport, String modeOfTravel, LocalDate date) {
		super();
		this.id = id;
		this.departureAirport = departureAirport;
		this.destinationAirport = destinationAirport;
		this.modeOfTravel = modeOfTravel;
		this.date = date;
	}

	public Journey() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getModeOfTravel() {
		return modeOfTravel;
	}

	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
 
	
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Journey[id=" + id + ", "
				+ "departureAirport=" + departureAirport + ", "
				+ "destinationAirport=" + destinationAirport + ", "
				+ "modeOfTravel=" + modeOfTravel + ", "
				+ "date=" + date +"]";
	}

}
