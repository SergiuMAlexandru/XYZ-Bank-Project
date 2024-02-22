package Tests;

import ObjectData.CustomerLoginObject;
import ObjectData.DepositObject;
import ObjectData.WithdrawalObject;
import Pages.CustomerLogin.CustomerLoginPage;
import Pages.CustomerLogin.DepositPage;
import Pages.CustomerLogin.WithdrawalPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WithdrawalTest extends Hooks {


    @Test
    public void testWithdrawal() {
        String username = "Harry Potter";
        double depositAmount = 150.00;
        double withdrawalAmount = 100.00;
        CustomerLoginObject customerLoginObject = new CustomerLoginObject();
        customerLoginObject.login(getDriver(), username);

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
        customerLoginPage.clickDepositButton();
        DepositPage depositPage = new DepositPage(getDriver());
        double initialBalance = Double.parseDouble(depositPage.getUserBalance());
        DepositObject depositObject = new DepositObject(getDriver());
        depositObject.depositAmount(depositAmount);
        assertTrue(depositPage.validateDeposit(depositAmount, initialBalance),
                "Deposit validation failed");



        customerLoginPage.clickWithdrawalButton();
        WithdrawalObject withdrawalObject = new WithdrawalObject(getDriver());
        withdrawalObject.enterWithdrawAmount(withdrawalAmount);                       // #########De cercetat
//                                                                          ######Face withdraw doar fara deposit
//
        WithdrawalPage withdrawalPage = new WithdrawalPage(getDriver());
        assertTrue(withdrawalPage.validateWithdrawal(withdrawalAmount, depositAmount),
                "Withdrawal validation failed");
    }
}
