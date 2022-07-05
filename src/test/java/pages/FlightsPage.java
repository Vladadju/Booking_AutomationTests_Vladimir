package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//span[contains(text(),'Flights')]")
    WebElement flightButton;
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_ROUNDTRIP]")
    WebElement checkboxRoundTrip;
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_ONEWAY]")
    WebElement checkboxOneWay;
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_MULTISTOP]")
    WebElement multiCitiCheckbox;
    @FindBy(css = "select.css-1k0jlfl")
    WebElement selectClass;
    // values for a class: "ECONOMY", "PREMIUM_ECONOMY", "BUSINESS" and "FIRST"
    @FindBy(css = "input[placeholder='Where from?']")
    WebElement airportFrom;
    @FindBy(css = "input[placeholder = 'Where to?']")
    WebElement airportTo;
    @FindBy(css = ".InputCheckbox-module__field___1zQqd")
    WebElement directFlightsOnlyCheckbox;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement searchButton;

    public void clickFlightButton(){
         click(flightButton);
    }
    public void enterAirportFrom(String airportFromText){
        typeText(airportFrom, airportFromText);
    }
    public void enterAirportTo(String airportToText){
        typeText(airportTo, airportToText);
    }
    public void selectClass(String classText){
        selectByValue(selectClass,classText);
    }
    public void clickOnSearchButton(){
        click(searchButton);
    }







}
