package tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    DriverManager driverManager;
    WebDriverWait wait;
    String URL = "https://www.booking.com/";

   @BeforeMethod
    public void init(){
       driverManager = DriverManagerFactory.getDriverManager("Chrome");
       driver = driverManager.getWebDriver("103");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(URL);

   }
//   @AfterMethod
//    public void tearDown(){
//       driverManager.quitWebDriver();
//   }
   @Test
    public void Test() throws InterruptedException {
       FlightsPage flightsPage = new FlightsPage(driver, wait);
       //flightsPage.fillFlightForm("English (US)","Belgrade", "Rome", "2022-07-28", "2022-08-10", "ECONOMY");
       flightsPage.clickFlightButton();
       flightsPage.clickOnLanguageIcon();
       flightsPage.selectLanguage("English (US)");
       flightsPage.enterAirportFrom("Lisbon");
       flightsPage.enterAirportTo("Rome");
       flightsPage.selectDates("2022-08-10", "2022-08-18");
       flightsPage.selectClasses("ECONOMY");
       flightsPage.clickOnSearchButton();


   }
}
