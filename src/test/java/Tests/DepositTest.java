package Tests;

import ObjectData.CustomerLoginObject;
import ObjectData.DepositObject;
import Pages.CustomerLogin.CustomerLoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DepositTest extends Hooks {

    @Test
    public void testDeposit() throws IOException {
        // Load test data from properties file
        Properties testData = new Properties();
        FileInputStream input = new FileInputStream("src/test/resources/TestData/DepositData.properties");
        testData.load(input);

        String username = testData.getProperty("username");
        double depositAmount = Double.parseDouble(testData.getProperty("depositAmount"));
        double initialBalance = Double.parseDouble(testData.getProperty("initialBalance"));

        CustomerLoginObject customerLoginObject = new CustomerLoginObject();
        customerLoginObject.login(getDriver(), username);

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(getDriver());
        customerLoginPage.clickDepositButton();

        DepositObject depositObject = new DepositObject(getDriver());
        depositObject.depositAmount(depositAmount);

        assert depositObject.validateDeposit(depositAmount, initialBalance);
    }
}
