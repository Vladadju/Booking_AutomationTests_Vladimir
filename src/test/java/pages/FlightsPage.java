package pages;

import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//button[@data-testid='header-language-picker-trigger']")
    WebElement languageButton;
    @FindBy(xpath = "//*[@id='b2indexPage']/header/nav[2]/ul/li[2]/a/span[1]")
    WebElement flightButton;
    ////*[@id='b2indexPage']/header/nav[2]/ul/li[2]/a/span[2]
    // "//span[contains(text(),'Flights')]"
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_ROUNDTRIP]")
    WebElement checkboxRoundTrip;
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_ONEWAY]")
    WebElement checkboxOneWay;
    @FindBy(css = "div[data-testid=searchbox_controller_trip_type_MULTISTOP]")
    WebElement multiCitiCheckbox;
    @FindBy(css = "select.css-1k0jlfl")
    WebElement selectClass;
    // values for a class: "ECONOMY", "PREMIUM_ECONOMY", "BUSINESS" and "FIRST"
    @FindBy(xpath = "//div[@data-testid='searchbox_origin_0']")
    WebElement airportFrom;
    @FindBy(css = "input[placeholder='Where from?']")
    WebElement airportFromInput;
    @FindBy(css = "input[placeholder='Where to?']")
    WebElement airportTo;
    // //*[@id='root']/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div/span/div/div
    @FindBy(xpath = "//input[@data-testid='searchbox_destination_input']")
    WebElement airportToInput;
    // //*[@id="root"]/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]/div/span/div/div
    // input[placeholder = 'Where to?']
    @FindBy(css = ".css-bwf0ll")
    List<WebElement> airportCheckBox;
    @FindBy(css = ".InputCheckbox-module__field___1zQqd")
    WebElement directFlightsOnlyCheckbox;
    @FindBy(xpath = "//div[@data-testid='searchbox_date_picker_desktop_calendar_undefined']")
    List<WebElement> dateField;
    @FindBy(css = ".Actionable-module__root___3OFQq.Calendar-module__control___2UIvK.Calendar-module__control--next___22G_h")
    WebElement nextDateButton;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement searchButton;
    @FindBy(xpath = "//div[contains(text(), 'Discover your next dream destination')]")
    WebElement sideClick;


    //values for languages:English (UK), English (US), Srpski, Čeština ...
    String languageLinkXpath = "//span[contains(text(),'$')]";
    public void clickOnLanguageIcon() throws InterruptedException {
        Thread.sleep(1000);
        languageButton.click();
    }
    public void selectLanguage(String language) throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.xpath(languageLinkXpath.replace("$", language))).click();
    }
    public void clickFlightButton() throws InterruptedException {
        Thread.sleep(2000);
         flightButton.click();
    }
    public void enterAirportFrom(String airportFromText) throws InterruptedException {
        Thread.sleep(1500);
        airportFrom.click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".css-1lq4ejz")).click();
        Thread.sleep(500);
        airportFromInput.sendKeys(airportFromText);
        Thread.sleep(500);
        airportCheckBox.get(0).click();
        Thread.sleep(500);
        sideClick.click();


    }
    public void clearAirportFrom() throws InterruptedException {
        Thread.sleep(1500);
        airportFrom.click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".css-1lq4ejz")).click();
        Thread.sleep(500);
        sideClick.click();
    }
    public void enterAirportTo(String airportToText) throws InterruptedException {
        airportTo.click();
        Thread.sleep(5000);
        airportToInput.click();
        Thread.sleep(500);
        airportToInput.sendKeys(airportToText);
        Thread.sleep(1000);
        airportCheckBox.get(0).click();
        Thread.sleep(500);
        sideClick.click();
    }
    public void selectDates(String startDate, String endDate){
        dateField.get(0).click();
//        click(dateField.get(0));
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
                nextDateButton.click();
            }else {
                driver.findElement(By.xpath("//span[@data-date-cell='" + endDate + "']")).click();
                break;
            }
        }
    }
    public void selectClasses(String classText){
        selectByValue(selectClass,classText);
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void fillFlightForm(String language, String airportFrom, String airportTo, String startDate, String endDate, String classText) throws InterruptedException {
        clickFlightButton();
        clickOnLanguageIcon();
        selectLanguage(language);
        enterAirportFrom(airportFrom);
        enterAirportTo(airportTo);
        selectDates(startDate, endDate);
        selectClasses(classText);
        clickOnSearchButton();

    }







}
