package com.qa.hwa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.dto.JourneyDTO;
import com.qa.hwa.persistence.domain.Journey;
import com.qa.hwa.service.JourneyService;

@CrossOrigin
@RestController
public class JourneyController {
	
	private JourneyService service;


	@Autowired
	public JourneyController(JourneyService service) {
		super();
		this.service = service;
	} 
	
	@PostMapping("/createJourney")
	public ResponseEntity<JourneyDTO> create(@RequestBody Journey journey) {
		return new ResponseEntity<JourneyDTO>(this.service.create(journey), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllJourneys")
	public ResponseEntity<List<JourneyDTO>> get() {
		return new ResponseEntity<List<JourneyDTO>>(this.service.read(), HttpStatus.OK);
	}
	
	@GetMapping("/getJourneyById/{id}")
	public ResponseEntity<JourneyDTO> read(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}
	
	@DeleteMapping("/deleteAJourney/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return this.service.delete(id) ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
				: new ResponseEntity<String>("DELETED", HttpStatus.NO_CONTENT);
	}


	@PutMapping("/updateJourney/{id}")
	public ResponseEntity<JourneyDTO> updateJourney(@RequestBody Journey journey, @PathVariable Long id) {
		return new ResponseEntity<JourneyDTO>(this.service.update(journey, id), HttpStatus.ACCEPTED);
	}

}
