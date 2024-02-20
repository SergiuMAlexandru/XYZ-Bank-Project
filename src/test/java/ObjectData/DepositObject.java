package ObjectData;

import Pages.CustomerLogin.DepositPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class DepositObject {
    private WebDriver driver;
    private final DepositPage depositPage;


    public DepositObject(WebDriver driver) {
        this.driver = driver;
        depositPage = new DepositPage(driver);
    }

    public void depositAmount(double amount) {
        depositPage.clearAndEnterNumericText(depositPage.getAmountInputField(), String.valueOf(amount));
        depositPage.clickDepositButton();
    }

//    public DepositObject (HashMap<String, String> testData){
//        populateObject(testData);
//
//    }
//
//
//    private void populateObject(HashMap<String, String> testData) {
//        for (String Key : testData.keySet()) {
//            switch (Key) {
//                case "depositAmount":
//                    setDepositAmount(testData.get(Key));
//                    break;
//
//
//            }
//        }
//    }
}
