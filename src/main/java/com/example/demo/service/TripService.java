package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TripDTO;
import com.example.demo.persistence.domain.Trip;
import com.example.demo.persistence.repo.TripRepo;

@Service
public class TripService {
	
private TripRepo repo; 

private ModelMapper mapper; 
	
	public TripService(TripRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo; 
		this.mapper = mapper; 
	}
	
	private TripDTO mapToDTO(Trip trip) {
		return this.mapper.map(trip, TripDTO.class);
	}
	
	public TripDTO create(Trip trip) {
		Trip saved = this.repo.save(trip);
		return this.mapToDTO(saved);
	}
	
	public List<TripDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

}
