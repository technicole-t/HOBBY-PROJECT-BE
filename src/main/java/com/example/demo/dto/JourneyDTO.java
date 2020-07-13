package com.example.demo.dto;

import java.time.LocalDate;

public class JourneyDTO {
	
	private Long id; 
	
	private String departureAirport; 
	
	private String destinationAirport; 
	
	private String modeOfTravel; 
	
	private LocalDate date;
	
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
	

	@Override
	public String toString() {
		return "JourneyDTO[id=" + id + ", "
				+ "departureAirport=" + departureAirport + ", "
				+ "destinationAirport=" + destinationAirport + ", "
				+ "modeOfTravel=" + modeOfTravel + ", "
				+ "date=" + date +"]";
	}


}
