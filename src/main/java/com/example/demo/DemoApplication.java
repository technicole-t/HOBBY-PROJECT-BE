package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext beanBag = 
		SpringApplication.run(DemoApplication.class, args);
	
//		JourneyRepo journeyDao = beanBag.getBean(JourneyRepo.class);
//		journeyDao.save(new Journey(0L, "Gatwick", "Bangkok", "Plane", LocalDate.of(2020, 9, 22)));
//		System.out.println(journeyDao.findByDepartureAirport("Gatwick"));
//	
//		TripRepo tripDao = beanBag.getBean(TripRepo.class);
//		tripDao.save(new Trip(0L, "Thailand"));
//		System.out.println(tripDao.findByTripName("Thailand"));
	
	
	}

}
