package com.qa.hwa.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.persistence.domain.Trip;

@Repository
public interface TripRepo extends JpaRepository<Trip, Long> {

	List<Trip> findByTripName(String tripName);
}
