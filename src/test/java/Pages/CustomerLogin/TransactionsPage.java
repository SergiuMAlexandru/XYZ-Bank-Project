//package Pages.CustomerLogin;
//
//import Pages.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import java.util.HashMap;
//import utils.DataFileReader;
//import utils.DataFileWriter;
//
//public class TransactionsPage extends BasePage {
//
//    public TransactionsPage(WebDriver driver){
//        super(driver);
//    }
//
//    @FindBy(id = "start")
//    private WebElement startDateInput;
//
//    @FindBy(id = "end")
//    private WebElement endDateInput;
//
//    @FindBy(css = "button[ng-click='reset()']")
//    private WebElement resetButton;
//
//    @FindBy(css = "table.table-bordered.table-striped tbody tr td:nth-of-type(2)")
//    private WebElement amountCell;
//
//
//    public WebElement getStartDateInput() {
//        return startDateInput;
//    }
//
//    public WebElement getEndDateInput() {
//        return endDateInput;
//    }
//
//    public void clickResetButton() {
//        elementMethods.clickElement(resetButton);
//    }
//
//    public void readTransactionTable(String tableData){
//        elementMethods.validateElementMessage(transactionsTable, tableData);
//    }
//
//    public class DataFileReader {
//        public static HashMap<String, String> readDataFromFile(String filePath) {
//        }
//    }
//
//    public class DataFileReader {
//        public static HashMap<String, String> readDataFromFile(String filePath) {
//        }
//    }
//}
