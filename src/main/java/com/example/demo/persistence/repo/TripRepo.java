package com.example.demo.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.domain.Trip;

@Repository
public interface TripRepo extends JpaRepository<Trip, Long> {

	List<Trip> findByTripName(String tripName);
}
