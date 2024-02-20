package Tests;

import ObjectData.CustomerLoginObject;
import ObjectData.DepositObject;
import Pages.CustomerLogin.CustomerLoginPage;
import Pages.CustomerLogin.DepositPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class DepositTest extends Hooks {

    @Test
    public void testDeposit() {
        String username = "Harry Potter";
        double depositAmount = 150;

        CustomerLoginObject customerLoginObject = new CustomerLoginObject();
        customerLoginObject.login(getDriver(), username);

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
        customerLoginPage.clickDepositButton();

        DepositPage depositPage = new DepositPage(getDriver());
        double initialBalance = Double.parseDouble(depositPage.getUserBalance());
        DepositObject depositObject = new DepositObject(getDriver());
        depositObject.depositAmount(depositAmount);

        assert depositPage.validateDeposit(depositAmount, initialBalance);
    }
}
