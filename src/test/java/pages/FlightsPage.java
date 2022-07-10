package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//button[@data-testid='header-language-picker-trigger']")
    WebElement languageButton;
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
    @FindBy(xpath = "//div[@data-testid='searchbox_date_picker_desktop_calendar']")
    List<WebElement> dateField;
    @FindBy(css = ".Actionable-module__root___3OFQq.Calendar-module__control___2UIvK.Calendar-module__control--next___22G_h")
    WebElement nextDateButton;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement searchButton;


    //values for languages:English (UK), English (US), Srpski, Čeština ...
    String languageLinkXpath = "//span[contains(text(),'$')]";
    public void clickOnLanguageIcon(){
        click(languageButton);
    }
    public void selectLanguage(String language){
        driver.findElement(By.xpath(languageLinkXpath.replace("$", language))).click();
    }
    public void clickFlightButton(){
         click(flightButton);
    }
    public void enterAirportFrom(String airportFromText){
        typeText(airportFrom, airportFromText);
    }
    public void enterAirportTo(String airportToText){
        typeText(airportTo, airportToText);
    }
    public void selectDates(String startDate, String endDate){
        click(dateField.get(0));
        while (true){
            List<WebElement> startDataList = driver.findElements(By.xpath("//span[@data-date-cell='" + startDate + "']"));

            if (startDataList.size() == 0){
                nextDateButton.click();
            }else {
                driver.findElement(By.xpath("//span[@data-date-cell='" + startDate + "']")).click();
                break;
            }
           }
        while (true){
            List<WebElement> endDataList = driver.findElements(By.xpath("//span[@data-date-cell='" + endDate + "']"));
            if (endDataList.size() == 0){
                click(nextDateButton);
            }else {
                driver.findElement(By.xpath("//span[@data-date-cell='" + endDate + "']")).click();
                break;
            }
        }
    }
    public void selectClass(String classText){
        selectByValue(selectClass,classText);
    }
    public void clickOnSearchButton(){
        click(searchButton);
    }







}
