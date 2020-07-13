package com.qa.hwa.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.hwa.dto.TripDTO;
import com.qa.hwa.persistence.domain.Trip;
import com.qa.hwa.service.TripService;

@RunWith(MockitoJUnitRunner.class)
public class TripControllerUnitTest {

	@InjectMocks
	private TripController controller; 
	
	@Mock
	private TripService service; 
	
	private List<Trip> tripList; 
	
	private Trip testTrip; 
	
	private Trip testTripWithID; 
	
	private TripDTO tripDTO; 
	
	final long id = 1L; 
	
	private ModelMapper mapper = new ModelMapper();
	
	private TripDTO mapToDTO(Trip trip) {
		return this.mapper.map(trip, TripDTO.class);
	}
	
	@Before
	public void init() {
		this.tripList = new ArrayList<>();
		this.testTrip = new Trip(1L, "Honeymoon");
		this.tripList.add(testTrip);
		this.testTripWithID = new Trip(testTrip.getTripId(), testTrip.getTripName());
		this.testTripWithID.setTripId(id);
		this.tripDTO = this.mapToDTO(testTripWithID);
	}
	
	@Test
	public void createTripTest () {
		when(this.service.create(testTrip)).thenReturn(this.tripDTO);
		
		assertEquals(new ResponseEntity<TripDTO>(this.tripDTO, HttpStatus.CREATED), this.controller.create(testTrip));
		
		verify(this.service, times(1)).create(this.testTrip);
		
	}
	
	@Test
	public void getAllTrips() {
		when(this.service.read()).thenReturn(this.tripList.stream().map(this::mapToDTO).collect(Collectors.toList()));
		
		assertFalse("Controller found no trips", this.controller.get().getBody().isEmpty());
		
		verify(service, times(1)).read();
	}
	
	
}
