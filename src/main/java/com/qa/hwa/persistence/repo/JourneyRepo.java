package com.qa.hwa.persistence.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.persistence.domain.Journey;

@Repository
public interface JourneyRepo extends JpaRepository<Journey, Long>{
	
	List<Journey> findByDepartureAirport(String departureAirport);
	
	List<Journey> findByDestinationAirport(String destinationAirport);
	
	List<Journey> findByModeOfTravel(String modeOfTravel);
	
	List<Journey> findByDate(LocalDate date);

}
