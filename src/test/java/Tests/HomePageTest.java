package Tests;

import Pages.HomePage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class HomePageTest extends Hooks {

    @Test
    public void testHomePage() {
        HomePage homePage = new HomePage(getDriver());

        homePage.clickCustomerLogin();

        homePage.clickHomeButton();

        homePage.clickBankManagerLogin();

        homePage.clickHomeButton();

        homePage.validateHomePage();
    }
}
