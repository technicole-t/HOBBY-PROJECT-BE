package com.example.demo.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	@Column(name="trip_id", unique = true)
	private Long tripId; 
	
	@Column(name="trip_name", nullable = false)
	private String tripName;

	public Trip(Long tripId, String tripName) {
		super();
		this.tripId = tripId;
		this.tripName = tripName;
	}
	
	@OneToMany(mappedBy = "trip")
	private List<Journey> journey = new ArrayList<>();
		

	public Trip() {
		
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	} 
	
	public List<Journey> getJourney() {
		return journey;
	}

	public void setJourney(List<Journey> journey) {
		this.journey = journey;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", tripName=" + tripName +"]";
	}
}
