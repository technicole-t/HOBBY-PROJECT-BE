package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class TripDTO {
	
	private Long id; 
	
	private String name; 
	
	private List<JourneyDTO> journeys = new ArrayList<>();
	
	public TripDTO (String name) {
		this.name = name; 
	}
	
	public TripDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JourneyDTO> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<JourneyDTO> journeys) {
		this.journeys = journeys;
	}
	
	@Override
	public String toString() {
		return "TripDTO[tripId=" + id + ", tripName=" + name +"]";
	}
	
}
