package Tests;

import ObjectData.CustomerLoginObject;
import ObjectData.WithdrawalObject;
import Pages.CustomerLogin.CustomerLoginPage;
import Pages.CustomerLogin.WithdrawalPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WithdrawalTest extends Hooks {

    @Test
    public void testWithdrawal() throws IOException {
        // Load test data from properties file into a HashMap
        Properties testData = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/TestData/WithdrawalData.properties");
        testData.load(input);

        String username = testData.getProperty("username");
        double withdrawalAmount = Double.parseDouble(testData.getProperty("withdrawalAmount"));
        CustomerLoginObject customerLoginObject = new CustomerLoginObject();
        customerLoginObject.login(getDriver(), username);

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
        customerLoginPage.clickWithdrawalButton();
        double initialBalance = Double.parseDouble(testData.getProperty("initialBalance"));

        WithdrawalObject withdrawalObject = new WithdrawalObject(getDriver());
        withdrawalObject.withdrawAmount(withdrawalAmount);


        WithdrawalPage withdrawalPage = new WithdrawalPage(getDriver());
        assert withdrawalPage.isErrorMessageDisplayed("Transaction Failed. You can not withdraw amount more than the balance.");
    }
}