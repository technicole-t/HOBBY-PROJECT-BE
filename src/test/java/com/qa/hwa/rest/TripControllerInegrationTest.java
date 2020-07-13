package com.qa.hwa.rest;

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
import com.qa.hwa.persistence.domain.Trip;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TripControllerInegrationTest {
	
	@Autowired
	private MockMvc mockMVC; 
	
	private Trip trip; 
	
	private Trip savedTrip; 
	
	@Autowired
	private ObjectMapper mapper; 
	
	
	@Before
	public void init() {
		this.trip = new Trip(1L, "Stag");
		this.savedTrip = new Trip(trip.getTripId(), trip.getTripName());
		this.savedTrip.setTripId(1L);
	}
	
	@Test
	public void testCreate() throws Exception {
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/createTrip");
		reqBuilder.contentType(MediaType.APPLICATION_JSON);
		reqBuilder.accept(MediaType.APPLICATION_JSON);
		reqBuilder.content(this.mapper.writeValueAsString(trip));
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(savedTrip));
		
		this.mockMVC.perform(reqBuilder).andExpect(matchStatus).andExpect(matchContent);
	}
	
	

}
