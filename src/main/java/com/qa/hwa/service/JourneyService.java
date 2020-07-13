package com.qa.hwa.service;

import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.hwa.dto.JourneyDTO;
import com.qa.hwa.exceptions.JourneyNotFoundException;
import com.qa.hwa.persistence.domain.Journey;
import com.qa.hwa.persistence.repo.JourneyRepo;

@Service
public class JourneyService {
	
private JourneyRepo repo; 

private ModelMapper mapper; 

	
	public JourneyService(JourneyRepo repo, ModelMapper mapper) {
		this.repo = repo; 
		this.mapper = mapper; 
	}
	
	private JourneyDTO mapToDTO(Journey journey) {
		return this.mapper.map(journey, JourneyDTO.class);
	}
	
	// INSERT INTO journey VALUES (...);
	public JourneyDTO create(Journey journey) {
		Journey saved = this.repo.save(journey);
		return this.mapToDTO(saved);
	}
	
	// SELECT * FROM journey; 
	public List<JourneyDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// SELECT * FROM journey WHERE id=; 
	public JourneyDTO read(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(JourneyNotFoundException::new));
	}
	
	// UPDATE journey SET date = ..., destinationAirport = ...;
	public JourneyDTO update(Journey journey, Long id) {
		Journey toUpdate = this.repo.findById(id).orElseThrow((JourneyNotFoundException::new));
		
		toUpdate.setDate(journey.getDate());
		toUpdate.setDepartureAirport(journey.getDepartureAirport());
		toUpdate.setDestinationAirport(journey.getDestinationAirport());
		toUpdate.setModeOfTravel(journey.getModeOfTravel());
		
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	// DELETE FROM journey WHERE id =;
	public boolean delete(Long id) {
		if (!this.repo.existsById(id)) {
			throw new JourneyNotFoundException();
		}
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
