package Tests;

import ObjectData.CustomerLoginObject;
import Pages.CustomerLogin.CustomerLoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;


public class CustomerLoginTest extends Hooks {

    @Test
    public void testCustomerLogin() {
        String username = "Harry Potter";
        CustomerLoginObject customerLoginObject = new CustomerLoginObject();
        customerLoginObject.login(getDriver(), username);

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
        customerLoginPage.clickTransactionsButton();
        customerLoginPage.isTransactionsRowDisplayed();

        customerLoginPage.clickBackButton();

        customerLoginPage.clickDepositButton();
        customerLoginPage.isDepositLabelDisplayed();

        customerLoginPage.clickWithdrawalButton();
        customerLoginPage.isWithdrawalLabelDisplayed();
    }
}
