package Pages.CustomerLogin;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    public DepositPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "input[type='number'][ng-model='amount']")
    private WebElement amountInputField;

    @FindBy(css = "button.btn.btn-default")
    private WebElement depositButton;

    @FindBy(css = "div.center strong:nth-of-type(2)")
    private WebElement userBalance;


    public WebElement getAmountInputField() {
        return amountInputField;
    }

    public void clearAndEnterNumericText(WebElement element, String text) {
        elementMethods.waitforElementVisibility(element);
        LoggerUtility.info("Clearing the input field");
        element.clear();
        if (text.matches("[0-9]+(\\.[0-9]+)?")) {
            LoggerUtility.info("Entering numeric text: " + text);
            element.sendKeys(text);
        } else {
            LoggerUtility.error("Invalid numeric input: " + text);
            throw new IllegalArgumentException("Invalid numeric input: " + text);
        }
    }

    public void clickDepositButton() {
        elementMethods.clickElement(depositButton);
        LoggerUtility.info("Clicked on the Deposit button");
    }

    public String getUserBalance() {
        elementMethods.waitforElementVisibility(userBalance);
        String balance = userBalance.getText().trim();
        LoggerUtility.info("Retrieved user balance: " + balance);
        return balance;
    }


    public boolean validateDeposit(double depositedAmount, double initialBalance) {
        double currentBalance = Double.parseDouble(getUserBalance());
        double expectedBalance = initialBalance + depositedAmount;
        LoggerUtility.info("Initial balance: " + initialBalance);
        LoggerUtility.info("Deposited amount: " + depositedAmount);
        LoggerUtility.info("Expected balance after deposit: " + expectedBalance);
        LoggerUtility.info("Current balance after deposit: " + currentBalance);
        boolean isValid = currentBalance == expectedBalance;
        LoggerUtility.info("Deposit validation result: " + isValid);
        return isValid;
    }
}
