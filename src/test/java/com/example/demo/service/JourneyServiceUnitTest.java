package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.example.demo.dto.JourneyDTO;
import com.example.demo.persistence.domain.Journey;
import com.example.demo.persistence.repo.JourneyRepo;

@RunWith(MockitoJUnitRunner.class)
public class JourneyServiceUnitTest {
	
	@InjectMocks
	private JourneyService service; 
	
	@Mock
	private JourneyRepo repo; 
	
	@Mock
	private ModelMapper mapper; 
	
	private List<Journey> journeyList; 
	
	private Journey testJourney; 
	
	private Journey testJourneyWithID; 
	
	private JourneyDTO journeyDTO; 
	
	final long id = 1L; 
	
	@Before 
	public void init() {
		this.journeyList = new ArrayList<>();
		this.journeyList.add(testJourney);
		this.testJourney = new Journey(1L, "Gatwick", "Bangkok", "Pane", LocalDate.of(2020, 9, 02));
		this.testJourneyWithID = new Journey(testJourney.getId(), testJourney.getDepartureAirport(), testJourney.getDestinationAirport(), testJourney.getModeOfTravel(), testJourney.getDate());
		this.testJourneyWithID.setId(id);
		this.journeyDTO = new ModelMapper().map(testJourneyWithID, JourneyDTO.class);
	}
	
	@Test
	public void createJourneyTest() {
		when(this.repo.save(testJourney)).thenReturn(testJourneyWithID);
		when(this.mapper.map(testJourneyWithID, JourneyDTO.class)).thenReturn(journeyDTO);
		
		assertEquals(this.journeyDTO, this.service.create(testJourney));
		
		verify(this.repo, times(1)).save(this.testJourney);
	}
	
	@Test
	public void readAllJourneysTest() {
		when(repo.findAll()).thenReturn(this.journeyList);
		
		assertFalse("No journeys have been found", this.service.read().isEmpty());
		
		verify(repo, times(1)).findAll();	
	}
	
	
	@Test 
	public void findJourneyByIdTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testJourneyWithID));
		when(this.mapper.map(testJourneyWithID, JourneyDTO.class)).thenReturn(journeyDTO);
		
		assertEquals(this.journeyDTO, this.service.read(this.id));
		
		verify(this.repo, times(1)).findById(id);
	}
	
	@Test
	public void deleteJourneyTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);
		
		this.service.delete(id);
		
		verify(this.repo, times(1)).deleteById(id);
		verify(this.repo, times(2)).existsById(id);
		
	}
	
	@Test 
	public void updateJourneyTest() {
		
		Journey newJourney = new Journey(1L, "Heathrow", "Brazil", "Yacht", LocalDate.of(2020, 10, 23));
	
		Journey updatedJourney = new Journey(newJourney.getId(), newJourney.getDepartureAirport(), newJourney.getDestinationAirport(), newJourney.getModeOfTravel(), newJourney.getDate());
		updatedJourney.setId(this.id);
		
		JourneyDTO updatedDTO = new ModelMapper().map(updatedJourney, JourneyDTO.class);
		
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testJourneyWithID));
		when(this.mapper.map(updatedJourney, JourneyDTO.class)).thenReturn(updatedDTO);
		
		when(this.repo.save(updatedJourney)).thenReturn(updatedJourney);
		
		assertEquals(updatedDTO, this.service.update(newJourney, this.id));
		
		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedJourney);
		
	}
	
	
}
