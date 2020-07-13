package com.qa.hwa.rest;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.persistence.domain.Journey;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JourneyControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC; 
	
	@Autowired
	private ObjectMapper mapper; 
	
	private Journey journey; 
	
	private Journey savedJourney; 
	
	
	@Before
	public void init () {
		this.journey = new Journey(1L, "gatwick", "cambodia", "plane", LocalDate.of(2021, 10, 15));
		this.savedJourney = new Journey(journey.getId(), journey.getDepartureAirport(), journey.getDestinationAirport(), journey.getModeOfTravel(), journey.getDate());
		this.savedJourney.setId(1L);
	}
	
	// creating mock request to create to see process
	@Test
	public void testCreate() throws Exception {
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/createJourney");
		reqBuilder.contentType(MediaType.APPLICATION_JSON);
		reqBuilder.accept(MediaType.APPLICATION_JSON);
		reqBuilder.content(this.mapper.writeValueAsString(journey));
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(savedJourney));	
				
		this.mockMVC.perform(reqBuilder).andExpect(matchStatus).andExpect(matchContent);
	}
	
	

}
