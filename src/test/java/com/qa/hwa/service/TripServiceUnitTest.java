package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.qa.hwa.dto.TripDTO;
import com.qa.hwa.persistence.domain.Trip;
import com.qa.hwa.persistence.repo.TripRepo;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceUnitTest {

	@InjectMocks 
	private TripService service; 
	
	@Mock
	private TripRepo repo; 
	
	@Mock 
	private ModelMapper mapper; 
	
	private List<Trip> tripList;
	
	private Trip testTrip; 
	
	private Trip testTripWithID; 
	
	private TripDTO tripDTO; 
	
	final long id = 1L; 
	
	@Before 
	public void init() {
		this.tripList = new ArrayList<>();
		this.tripList.add(testTrip);
		this.testTrip = new Trip(1L, "Birthday");
		this.testTripWithID = new Trip(testTrip.getTripId(), testTrip.getTripName());
		this.testTripWithID.setTripId(id);
		this.tripDTO = new ModelMapper().map(testTripWithID, TripDTO.class);
	}
	
	@Test
	public void createTripTest() {
		when(this.repo.save(testTrip)).thenReturn(testTripWithID);
		when(this.mapper.map(testTripWithID, TripDTO.class)).thenReturn(tripDTO);
		
		assertEquals(this.tripDTO, this.service.create(testTrip));
		
		verify(this.repo, times(1)).save(this.testTrip);
	}
	
	@Test 
	public void readAllTrips() {
		when(repo.findAll()).thenReturn(this.tripList);
		
		assertFalse("No trips have been found", this.service.read().isEmpty());
		
		verify(repo, times(1)).findAll();
	}
	
	
	
}
