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

    @FindBy(css = "span.error.ng-binding")
    private WebElement errorMessage;

    public void clearAndEnterWithdrawalAmount(String amount) {
        elementMethods.fillElement(withdrawalAmountInputField, amount);
    }

    public void clickWithdrawButton() {
        elementMethods.clickElement(withdrawButton);
    }

    public String getUserBalance() {
        return userBalance.getText().trim();
    }

    public boolean validateWithdrawal(double withdrawnAmount, double initialBalance) {

        boolean isErrorMessageDisplayed = isErrorMessageDisplayed("Transaction Failed. You can not withdraw amount more than the balance.");
        if (isErrorMessageDisplayed) {
            LoggerUtility.info("Error message displayed: Transaction Failed. You can not withdraw amount more than the balance.");
            return false; // Withdrawal failed due to insufficient balance
        }
        double currentBalance = Double.parseDouble(getUserBalance());
        double expectedBalance = initialBalance - withdrawnAmount;
        LoggerUtility.info("Initial balance: " + initialBalance);
        LoggerUtility.info("Withdrawn amount: " + withdrawnAmount);
        LoggerUtility.info("Expected balance after withdrawal: " + expectedBalance);
        LoggerUtility.info("Current balance after withdrawal: " + currentBalance);
        boolean isValid = currentBalance == expectedBalance;
        LoggerUtility.info("Withdrawal validation result: " + isValid);
        return isValid;
    }

    public boolean isErrorMessageDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = errorMessage.getText().trim();
        LoggerUtility.info("Actual error message: " + actualErrorMessage);
        LoggerUtility.info("Expected error message: " + expectedErrorMessage);
        LoggerUtility.info("Error validation result: " + actualErrorMessage.equals(expectedErrorMessage));
        return actualErrorMessage.equals(expectedErrorMessage);
    }

}
