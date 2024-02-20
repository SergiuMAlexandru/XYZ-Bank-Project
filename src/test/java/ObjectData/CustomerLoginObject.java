package ObjectData;

import Logger.LoggerUtility;
import Pages.CustomerLogin.CustomerLoginPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class CustomerLoginObject {

    private String userName;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void login(WebDriver driver, String userName) {
        HomePage homePage = new HomePage(driver);
        homePage.clickCustomerLogin();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.selectUser(userName);
        customerLoginPage.clickLoginButton();
        customerLoginPage.isWelcomeMessageDisplayed(userName);
        LoggerUtility.info("Logged in as: " + userName);
    }


}
