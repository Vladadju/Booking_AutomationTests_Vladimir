package tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    DriverManager driverManager;
    String URL = "https://www.booking.com/";

   @BeforeMethod
    public void init(){
       driverManager = DriverManagerFactory.getDriverManager("Chrome");
       driver = driverManager.getWebDriver("103");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(URL);

   }
   @AfterMethod
    public void tearDown(){
       driverManager.quitWebDriver();
   }
}
