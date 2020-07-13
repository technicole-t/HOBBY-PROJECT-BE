package com.qa.hwa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.dto.TripDTO;
import com.qa.hwa.persistence.domain.Trip;
import com.qa.hwa.service.TripService;

@CrossOrigin
@RestController
//@RequestMapping("/trip")
public class TripController {

	private TripService service; 
	
	@Autowired
	public TripController(TripService service) {
		super();
		this.service = service;
	} 
	
	// WORKING!!
	@PostMapping("/createTrip")
	public ResponseEntity<TripDTO> create(@RequestBody Trip trip) {
		return new ResponseEntity<TripDTO>(this.service.create(trip), HttpStatus.CREATED);
	}
	
	// WORKING!!
	@GetMapping("/getTrips")
	public ResponseEntity<List<TripDTO>> get(){
		return new ResponseEntity<List<TripDTO>>(this.service.read(), HttpStatus.OK);
	}
}
