package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {
	

	public WebDriver driver;
	LandingPage LandingPageobj; 
	//this line is for using log4j to get logs
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeTitleDriver() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		//Thread.sleep(3000);
		log.info("Navigated to homepage");

	}

	
	@Test
	public void validateAppTitle() throws IOException, InterruptedException 
	{
		// creating object to that class and invoke methods of it
		// compare text from browser with actual text using assertion
		LandingPageobj= new LandingPage(driver);
		
		System.out.println(LandingPageobj.getTitle().getText());
		Assert.assertEquals(LandingPageobj.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");

		
	}

	@Test
	public void validateHeader() throws IOException, InterruptedException 
	{
		// creating object to that class and invoke methods of it
		// compare text from browser with actual text using assertion
		Assert.assertEquals(LandingPageobj.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	
	@AfterTest
	public void closeTitleDriver()
	{
		driver.close();
	}
}
