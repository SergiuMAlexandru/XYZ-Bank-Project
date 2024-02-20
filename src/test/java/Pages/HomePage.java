package Pages;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[text()='XYZ Bank']")
    private WebElement logo;

    @FindBy(xpath = "//button[text()='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//button[text()='Customer Login']")
    public WebElement customerLogin;


    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    public WebElement bankManagerLogin;


    public void clickCustomerLogin(){
        elementMethods.clickElement(customerLogin);
        LoggerUtility.info("The user clicks on the Customer Login button");
    }

    public void clickBankManagerLogin(){
        elementMethods.clickElement(bankManagerLogin);
        LoggerUtility.info("The user clicks on the Bank Manager Login button");
    }

    public void clickHomeButton() {
        elementMethods.clickElement(homeButton);
        LoggerUtility.info("The user clicks on the Home button");
    }

    public void validateHomePage() {
        elementMethods.validateElementMessage(logo, "XYZ Bank");
        LoggerUtility.info("The logo's presence has been validated with success");
        elementMethods.validateElementMessage(customerLogin, "Customer Login");
        LoggerUtility.info("The CustomerLogin's presence has been validated with success");
        elementMethods.validateElementMessage(bankManagerLogin, "Bank Manager Login");
        LoggerUtility.info("The BankManagerLogin's presence has been validated with success");

    }
}
