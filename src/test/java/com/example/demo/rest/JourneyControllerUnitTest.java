package com.example.demo.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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

import com.example.demo.dto.JourneyDTO;
import com.example.demo.persistence.domain.Journey;
import com.example.demo.service.JourneyService;

@RunWith(MockitoJUnitRunner.class)
public class JourneyControllerUnitTest {
	
	@InjectMocks
	private JourneyController controller; 
	
	@Mock
	private JourneyService service; 
	
	private List<Journey> journeyList; 
	
	private Journey testJourney; 
	
	private Journey testJourneyWithID; 
	
	private JourneyDTO journeyDTO; 
	
	final long id = 1L; 
	
	private ModelMapper mapper = new ModelMapper(); 
	
	private JourneyDTO mapToDTO(Journey journey) {
		return this.mapper.map(journey, JourneyDTO.class);
	}
	
	@Before
	public void init() {
		this.journeyList = new ArrayList<>();
		this.testJourney = new Journey(1L, "Miami", "Dubai", "Plane", LocalDate.of(2022, 12, 20));
		this.journeyList.add(testJourney);
		this.testJourneyWithID = new Journey(testJourney.getId(), testJourney.getDepartureAirport(), testJourney.getDestinationAirport(), testJourney.getModeOfTravel(), testJourney.getDate());
		this.testJourneyWithID.setId(1L);
		this.journeyDTO = this.mapToDTO(testJourneyWithID);
	}
	
	@Test
	public void createJourneyTest() {
		when(this.service.create(testJourney)).thenReturn(this.journeyDTO);
		
		assertEquals(new ResponseEntity<JourneyDTO>(this.journeyDTO, HttpStatus.CREATED), this.controller.create(testJourney));
		
		verify(this.service, times(1)).create(this.testJourney);
	}
	
	
	@Test 
	public void getAllJourneysTest() {
		when(service.read()).thenReturn(this.journeyList.stream().map(this::mapToDTO).collect(Collectors.toList()));
		
		assertFalse("Controller could not find journeys", this.controller.get().getBody().isEmpty());
		
		verify(service, times(1)).read();
	}
	
	@Test
	public void findJourneyByIDTest() {
		when(this.service.read(this.id)).thenReturn(this.journeyDTO);
		
		assertEquals(new ResponseEntity<JourneyDTO>(this.journeyDTO, HttpStatus.OK), this.controller.read(this.id));
		
		verify(this.service, times(1)).read(this.id);
	}
	
	@Test
	public void deleteDuckTest() {
		this.controller.delete(id);
		
		verify(this.service, times(1)).delete(id);
	}
	
	// do update test 

}
