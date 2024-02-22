package ObjectData;

import Pages.CustomerLogin.DepositPage;
import HelpMetods.ElementMethods;
import org.openqa.selenium.WebDriver;

public class DepositObject {

    private final WebDriver driver;
    private final DepositPage depositPage;
    private final ElementMethods elementMethods;

    public DepositObject(WebDriver driver) {
        this.driver = driver;
        this.depositPage = new DepositPage(driver);
        this.elementMethods = new ElementMethods(driver);
    }

    public void depositAmount(double amount) {
        depositPage.clearAndEnterNumericText(String.valueOf(amount));
        depositPage.clickDepositButton();
    }

    public String getUserBalance() {
        return depositPage.getUserBalance();
    }

    public boolean validateDeposit(double depositedAmount, double initialBalance) {
        return depositPage.validateDeposit(depositedAmount, initialBalance);
    }
}
