package com.qa.hwa.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.qa.hwa.selenium.pages.HomePage;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeTest {
	
	@LocalServerPort
	private int port; 
	
	private WebDriver driver; 
	
	@Before
	public void init() {
		System.setProperty("webdriver.chromedriver", "chromedriver");
		this.driver = new ChromeDriver();
	}
	
	@After
	public void pullDown() {
		driver.quit();
	}
	
	@Test
	public void testCreateTrip() {
		driver.get("http://localhost:" + port);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.getCreateTrip().sendKeys("Vegas");
		home.getReadAllTrips().click();
	}

}
