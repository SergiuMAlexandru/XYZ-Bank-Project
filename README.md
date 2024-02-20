# **XYZ Bank**
# Test Automation
**XYZ Bank** is a sample banking application developed for educational purposes. It provides basic banking functionalities such as account management, fund transfers, transaction history, and more.

**Website**: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
**Test Engineer**: Sergiu Marian Alexandru

**Features**
1. User authentication
2. Deposit and withdrawal functionalities:
* Deposit and Validation
* Withdrawal and Validation
3. Transaction history and Validation


1. **Testing Purpose**
2. **Test Environment** 

Operating System: Windows OS  
Browser: Chrome, Edge, Firefox   
Java: 11.0.20   
Selenium: 4.17.0   
Development IDE: IntelliJ IDEA 2021.3 (Community Edition)

3. **Test Scenarios** 

* __Validating the Homepage functionalities:__
1. Open the browser and navigate https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
  . 
2. Navigate to the CustomerLoginPage and back and then to the BankManagerLoginPage.
3. Validate HomePage
* **Validating CustomerLogin functionalities:**
1. Navigate to the CustomerLoginPage and select an user from the drop-down menu.
2. Click and validate (by presence of elements) 3 main functionalities: TransactionsPage, DepositPage and WithdrawPage.

* **DepositPage Validation**
1. Navigate to the DepositPage
2. Perform a deposit and validate the result by checking the balance.
* **WithdrawalPage Validation**
1. Navigate to the WithdrawalPage
2. Perform a withdrawal and validate the result by checking the balance.
* **TransactionsPage Validation**
1. Navigate to the TransactionsPage
2. Perform a deposit
3. Read the data from the table and compare it with your deposit and see if they match.
4. Also be able to save the data from the TransactionsHistory in a file.

