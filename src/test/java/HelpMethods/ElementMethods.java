package HelpMetods;

import Logger.LoggerUtility;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {
    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitforElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void clickElement(WebElement element){
        waitforElementVisibility(element);
        element.click();
    }


    public void fillElement(WebElement element, String value){
        waitforElementVisibility(element);
        element.sendKeys(value);
    }

    public void fillElement(WebElement element,Keys keyboardPress){
        waitforElementVisibility(element);
        element.sendKeys(keyboardPress);
    }

    public void fillElement(WebElement element, String value, Keys keyboardPress){
        waitforElementVisibility(element);
        element.sendKeys(value);
        element.sendKeys(keyboardPress);
    }

    public void fillElement(WebElement element, String value, String keyboardPress){
        waitforElementVisibility(element);
        element.sendKeys(value);
        element.sendKeys(keyboardPress);
    }

    public void scrollByPixels (Integer x, Integer y){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy("+ x +","+ y +")", "");
    }

    public void clickJSElement(WebElement element){
        waitforElementVisibility(element);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void validateElementMessage(WebElement element, String value){
        waitforElementVisibility(element);
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, value);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            LoggerUtility.info("Error: " + e);
            return false;
        }
    }

}
