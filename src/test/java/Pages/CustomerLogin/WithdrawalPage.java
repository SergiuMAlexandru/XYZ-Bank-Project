package Pages.CustomerLogin;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawalPage extends BasePage {


    public WithdrawalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='number']")
    private WebElement withdrawalAmountInputField;


    @FindBy(xpath = "//button[@class='btn btn-default' and text()='Withdraw']")
    private WebElement withdrawButton;

    @FindBy(css = "div.center strong:nth-of-type(2)")
    private WebElement userBalance;


    public WebElement getWithdrawalAmountInputField() {
        return withdrawalAmountInputField;
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

    public void clickWithdrawButton() {
        elementMethods.clickElement(withdrawButton);
        LoggerUtility.info("Clicked on the Withdraw button");
    }

    public String getUserBalance() {
        elementMethods.waitforElementVisibility(userBalance);
        String balance = userBalance.getText().trim();
        LoggerUtility.info("Retrieved user balance: " + balance);
        return balance;
    }

    public boolean validateWithdrawal(double withdrawnAmount, double initialBalance) {
        double currentBalance = Double.parseDouble(getUserBalance());
        double expectedBalance = initialBalance - withdrawnAmount;
        boolean isValid = currentBalance == expectedBalance;
        LoggerUtility.info("Initial balance: " + initialBalance);
        LoggerUtility.info("Withdrawn amount: " + withdrawnAmount);
        LoggerUtility.info("Expected balance after withdrawal: " + expectedBalance);
        LoggerUtility.info("Current balance after withdrawal: " + currentBalance);
        LoggerUtility.info("Withdrawal validation result: " + isValid);
        if (isValid) {
            LoggerUtility.info("Withdrawal validation passed. Current balance after withdrawal: " + currentBalance);
        } else {
            LoggerUtility.error("Withdrawal validation failed. Expected balance after withdrawal: " + expectedBalance + ", Actual balance: " + currentBalance);
        }
        return isValid;
    }

}
