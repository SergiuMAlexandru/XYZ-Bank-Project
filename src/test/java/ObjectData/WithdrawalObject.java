package ObjectData;

import Pages.CustomerLogin.WithdrawalPage;
import HelpMetods.ElementMethods;
import org.openqa.selenium.WebDriver;

public class WithdrawalObject {

    private final WithdrawalPage withdrawalPage;
    private final ElementMethods elementMethods;

    public WithdrawalObject(WebDriver driver) {
        this.withdrawalPage = new WithdrawalPage(driver);
        this.elementMethods = new ElementMethods(driver);
    }

    public void withdrawAmount(double amount) {
        withdrawalPage.clearAndEnterWithdrawalAmount(String.valueOf(amount));
        withdrawalPage.clickWithdrawButton();
    }

    public String getUserBalance() {
        return withdrawalPage.getUserBalance();
    }

    public boolean validateWithdrawal(double withdrawnAmount, double initialBalance) {
        return withdrawalPage.validateWithdrawal(withdrawnAmount, initialBalance);
    }
}
