package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void typeText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            if (text != null){
                element.clear();
                element.sendKeys(text);
            }else {
                System.out.println("Parameter ws null!");
            }
        }catch (StaleElementReferenceException e){
            if (text != null){
                element.clear();
                element.sendKeys(text);
            }else {
                System.out.println("Parameter was null!");
            }
        }
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

            element.click();
        }catch (StaleElementReferenceException e){
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();

            element.click();
        }
    }
    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/screenshot/"+fileName+"_"+System.currentTimeMillis()+".png"));
    }
    public void assertEquals(WebElement element, String expectedValue){
        Assert.assertEquals(element.getText(),expectedValue);
    }
    public void selectByValue(WebElement element, String value){
        try {
            if (value != null){
                Select selectClass = new Select(element);
                selectClass.selectByValue(value);
            }else{
                System.out.println("Parameter was null!");
            }
        }catch (StaleElementReferenceException e){
            if (value != null){
                Select selectClass = new Select(element);
                selectClass.selectByValue(value);
            }else {
                System.out.println("Parameter was null!");
            }
        }
    }

}
