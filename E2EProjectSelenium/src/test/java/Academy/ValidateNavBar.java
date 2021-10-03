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

public class ValidateNavBar extends Base {
	
	public WebDriver driver;
	
	//this line is for using log4j to get logs
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeNavDriver() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		//Thread.sleep(3000);


	}
	@Test
	public void validateAppNavBar() throws IOException, InterruptedException 
	{
		// creating object to that class and invoke methods of it
		LandingPage LandingPageobj = new LandingPage(driver);
		// compare text from browser with actual text using assertion
		Assert.assertTrue(LandingPageobj.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed successfully");

	}

	@AfterTest
	public void closeNavDriver() {
		driver.close();
	}
}
