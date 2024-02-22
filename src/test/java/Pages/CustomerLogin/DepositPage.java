package Pages.CustomerLogin;

import HelpMetods.ElementMethods;
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

    public void clearAndEnterNumericText(String text) {
        elementMethods.fillElement(amountInputField, text);
    }

    public void clickDepositButton() {
        elementMethods.clickElement(depositButton);
    }

    public String getUserBalance() {
        return userBalance.getText().trim();
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
