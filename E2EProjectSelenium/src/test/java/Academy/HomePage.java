package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	//this line is for using log4j to get logs
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void initializeHome() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text)
			throws IOException, InterruptedException 
	{

		driver.get(prop.getProperty("url"));
		// creating object to that class and invoke methods of it
		LandingPage LandingPageobj = new LandingPage(driver);
		LandingPageobj.getLogin().click();
		//Thread.sleep(3000);
		
		LoginPage LoginPageobj = new LoginPage(driver);
		LoginPageobj.getEmail().sendKeys(username);
		LoginPageobj.getPassword().sendKeys(password);
		//Thread.sleep(2000);
		System.out.println(text);
		log.info(text);
		
		LoginPageobj.getLogin().click();
	
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// column stand for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@yahoo.com";// 0th row 0th column
		data[0][1] = "user1";// 0th row 1st column
		data[0][2] = "nonrestricted user";
		// 1st row
		data[1][0] = "Restricteduser@yahoo.com";// 1st row 0th column
		data[1][1] = "user2";// 1st row 1st column
		data[1][2] = "restricted user";
		return data;
	}

	@AfterTest
	public void closeHomeDriver()
	{
		driver.close();
	}
}
