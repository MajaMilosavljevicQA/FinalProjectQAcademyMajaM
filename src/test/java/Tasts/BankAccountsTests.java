package Tasts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountsTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
    }

    @Test(priority = 10)
    public void inspectBankAccountsAndCreateNewAccountAndDeleteIt() {
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.clickSignInButton();
        sidebarPage.assertAccountBalanceTxt();
        sidebarPage.assertBankAccountLink();
        sidebarPage.clickBankAccountLink();
        bankAccountsPage.assertBankAccounutsURL();
        bankAccountsPage.assertBankAccountTitle();
        bankAccountsPage.assertCreateBtn();
        bankAccountsPage.assertDeleteBtn();
        bankAccountsPage.assertUserBankAccount();
        bankAccountsPage.clickCreateBtn();
        newBankAccountPage.assertNewBankAccountURL();
        newBankAccountPage.assertCreateBankAccTxt();
        newBankAccountPage.assertBankAccountBankNameInputField();
        newBankAccountPage.assertBankAccountRoutingNumberInputField();
        newBankAccountPage.assertAccountNumberInputField();
        newBankAccountPage.assertAndClickSaveButton();
        newBankAccountPage.assertAndClickSaveButton();// BUG needs to be clicked two times
        newBankAccountPage.assertBankAccountEmptyBankNameHelperTxt();
        for (int i = 1; i < excelReader.getLastRow("Login-SignIn")-1; i++) {
            String bankName = excelReader.getStringData("Login-SignIn", i, 4);
            String routingNumber = excelReader.getStringData("Login-SignIn", i, 5);
            String accountNumber = excelReader.getStringData("Login-SignIn", i, 6);
            newBankAccountPage.bankNameInputFieldSendKeys(bankName);
            newBankAccountPage.routingNumberInputFieldSendKeys(routingNumber);
            newBankAccountPage.accountNumberInputFieldSendKeys(accountNumber);
            newBankAccountPage.assertAndClickSaveButton();
            bankAccountsPage.assertBankAccounutsURL();
            // Assert.  // todo ask team how to asert new bank account name
            bankAccountsPage.clickDeleteBtn();//BUG --> DOES NOT DELETE ACC

            //the way it should work --> deletes first added account from excel
            //todo ask team how to make list and delete item that has expected text inserted from excel sheet
            //Assert that deleted account is not displayed --> only text remains that shows "BankAccount"(Deleted)
            bankAccountsPage.clickCreateBtn();
        }
    }



}
