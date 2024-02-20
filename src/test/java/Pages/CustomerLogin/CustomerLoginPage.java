package Pages.CustomerLogin;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelectDropdown;

    @FindBy(className = "btn-default")
    private WebElement loginButton;


    @FindBy(css = "button.btn.logout[ng-show='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(className = "fontBig")
    private WebElement userName;

    @FindBy(css = "button[ng-click='transactions()']")
    private WebElement transactionsButton;

    @FindBy(css = "button[ng-click='deposit()']")
    private WebElement depositButton;

    @FindBy(css = "button[ng-click='withdrawl()']")
    private WebElement withdrawalButton;

    @FindBy(css = "tr > td > a[href='#'][ng-click*='date']")
    private WebElement transactionsRow;


    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Amount to be Deposited')]")
    private WebElement depositLabel;


    @FindBy(xpath = "//label[contains(text(),'Amount to be Withdrawn')]")
    private WebElement withdrawalLabel;

    @FindBy(xpath = "//button[text()='Back']")
    private WebElement backButton;


    public void selectUser(String userName) {
        Select dropdown = new Select(userSelectDropdown);
        dropdown.selectByVisibleText(userName);
        LoggerUtility.info("User has been selected for login");
    }

    public void clickLoginButton() {
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("Clicked on the Login button");
    }

    public void clickLogoutButton() {
        elementMethods.clickElement(logoutButton);
        LoggerUtility.info("Clicked on the Logout button");
    }

    public boolean isWelcomeMessageDisplayed(String userName) {
        elementMethods.waitforElementVisibility(welcomeMessage);
        String actualWelcomeMessage = welcomeMessage.getText().trim();
        String expectedWelcomeMessage = "Welcome " + userName + " !!";
        LoggerUtility.info("Actual Welcome Message: " + actualWelcomeMessage);
        LoggerUtility.info("Expected Welcome Message: " + expectedWelcomeMessage);
        LoggerUtility.info("Results match: "+ actualWelcomeMessage.equals(expectedWelcomeMessage));
        return actualWelcomeMessage.equals(expectedWelcomeMessage);
    }


    public void clickTransactionsButton() {
        elementMethods.clickElement(transactionsButton);
        LoggerUtility.info("Clicked on the Transactions button");
    }

    public void clickDepositButton() {
        elementMethods.clickElement(depositButton);
        LoggerUtility.info("Clicked on the Deposit button");
    }

    public void clickWithdrawalButton() {
        elementMethods.clickElement(withdrawalButton);
        LoggerUtility.info("Clicked on the Withdrawal button");
    }

    public boolean isTransactionsRowDisplayed() {
        LoggerUtility.info("Transaction row is displayed: " + elementMethods.isElementDisplayed(transactionsRow));
        return elementMethods.isElementDisplayed(transactionsRow);}

    public boolean isDepositLabelDisplayed() {
        LoggerUtility.info("Deposit label is displayed: " + elementMethods.isElementDisplayed(depositLabel));
        return elementMethods.isElementDisplayed(depositLabel);
    }

    public boolean isWithdrawalLabelDisplayed() {
        LoggerUtility.info("Withdrawl label is displayed: " + elementMethods.isElementDisplayed(withdrawalLabel));
        return elementMethods.isElementDisplayed(withdrawalLabel);
    }

    public void clickBackButton() {
        elementMethods.clickElement(backButton);
        LoggerUtility.info("Clicked on the Back button");
    }

}




