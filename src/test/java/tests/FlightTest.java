package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FlightTest {
    WebDriver driver;
    DriverManager driverManager;
    WebDriverWait wait;
    String URL = "https://www.booking.com/";

   @BeforeMethod
    public void init(){
       driverManager = DriverManagerFactory.getDriverManager("Chrome");
       driver = driverManager.getWebDriver("105");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(URL);

   }
   @AfterMethod
    public void tearDown(){
//       driverManager.quitWebDriver();
   }
   // TC01 Verify that user will see available flights if he/she fill booking flight form correctly.
   @Test
    public void positiveTest() throws InterruptedException, IOException {
       FlightsPage flightsPage = new FlightsPage(driver, wait);
       //flightsPage.fillFlightForm("English (US)","Belgrade", "Rome", "2022-07-28", "2022-08-10", "ECONOMY");
       flightsPage.clickFlightButton();
       flightsPage.clickOnLanguageIcon();
       flightsPage.selectLanguage("English (US)");
       flightsPage.enterAirportFrom("Lisbon");
       flightsPage.enterAirportTo("Rome");
       flightsPage.selectDates("2022-10-02", "2022-10-18");
       flightsPage.selectClasses("ECONOMY");
       flightsPage.clickOnSearchButton();
       Assert.assertEquals(driver.findElement(By.cssSelector(".css-19vrgv4"))
               .getText(),"Booking.com is part of Booking Holdings Inc., the world leader in online travel and related services.");
       flightsPage.takeScreenshot("Positive Test");


   }
   // TC02 Verify that user will not see available flights if he/she do not enter airport to destination.
    @Test
    public void negativeTest1() throws InterruptedException, IOException {
       FlightsPage flightsPage = new FlightsPage(driver, wait);
       flightsPage.clickFlightButton();
       flightsPage.clickOnLanguageIcon();
       flightsPage.selectLanguage("English (US)");
       flightsPage.enterAirportFrom("Lisbon");
       flightsPage.selectDates("2022-10-02", "2022-10-18");
       flightsPage.selectClasses("ECONOMY");
       flightsPage.clickOnSearchButton();
       Assert.assertEquals(driver.findElement(By.xpath("//*[@id='basiclayout']/div/div[1]/div/div/div[2]/div[2]/div/div[4]/div")).
               getText(),"Select airports and dates");
       flightsPage.takeScreenshot("Negative Test 1");
    }
    // TC03 Verify that user will not see available flights if he/she do not enter airport from destination.
    @Test
    public void negativeTest2() throws InterruptedException, IOException {
       FlightsPage flightsPage = new FlightsPage(driver,wait);
        flightsPage.clickFlightButton();
        flightsPage.clickOnLanguageIcon();
        flightsPage.selectLanguage("English (US)");
        flightsPage.clearAirportFrom();
        flightsPage.enterAirportTo("Rome");
        flightsPage.selectDates("2022-10-02", "2022-10-18");
        flightsPage.selectClasses("ECONOMY");
        flightsPage.clickOnSearchButton();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='basiclayout']/div/div[1]/div/div/div[2]/div[2]/div/div[4]/div")).
                getText(),"Select airports and dates");
        flightsPage.takeScreenshot("Negative Test 2");

    }
}
