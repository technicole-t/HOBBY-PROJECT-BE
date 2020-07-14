package com.qa.hwa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id = "user-input-trip-name")
	private WebElement userInputTripName;
	
	@FindBy(id = "start-planning-button")
	private WebElement startPlanningButton; 
	
	@FindBy(id = "readAllTrips")
	private WebElement readAllTrips; 
	
	@FindBy(id = "tripOutput")
	private WebElement tripOutput;
	
	public void createTrip(String name) {
		this.userInputTripName.sendKeys(name);
		this.readAllTrips.click();
	}
	
	public WebElement getCreateTrip() {
		return userInputTripName; 
	}
	
	public WebElement getReadAllTrips() {
		return readAllTrips;
	}
}
