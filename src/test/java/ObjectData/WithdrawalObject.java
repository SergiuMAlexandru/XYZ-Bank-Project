package ObjectData;

import Pages.CustomerLogin.WithdrawalPage;
import org.openqa.selenium.WebDriver;

public class WithdrawalObject {
    private final WebDriver driver;
    private final WithdrawalPage withdrawalPage;

    public WithdrawalObject(WebDriver driver) {
        this.driver = driver;
        this.withdrawalPage = new WithdrawalPage(driver);
    }

    public void enterWithdrawAmount(double amount) {
        withdrawalPage.clearAndEnterNumericText(withdrawalPage.getWithdrawalAmountInputField(), String.valueOf(amount));
        withdrawalPage.clickWithdrawButton();
    }

}
