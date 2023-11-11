package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewBankAccountPage extends BaseTest {

    public NewBankAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/h2")
    WebElement createBankAccountTxt;

    public void assertCreateBankAccTxt() {
        Assert.assertTrue(createBankAccountTxt.isDisplayed());
        Assert.assertEquals(createBankAccountTxt.getText(), "Create Bank Account");
    }

    @FindBy(id = "bankaccount-bankName-input")
    WebElement bankNameInputField;

    public void assertBankAccountBankNameInputField() {
        Assert.assertTrue(bankNameInputField.isDisplayed());
        //  Assert.assertTrue(bankNameInputField.isEnabled()); //Check if it is necessary
    }

    public void bankNameInputFieldSendKeys(String bankName) {
        bankNameInputField.clear();
        bankNameInputField.sendKeys(bankName);
    }

    @FindBy(id = "bankaccount-bankName-input-helper-text")
    WebElement bankNameHelperTxt;  // Enter a bank name

    //Must contain at least 5 characters
    public void assertBankAccountEmptyBankNameHelperTxt() {
        Assert.assertTrue(bankNameHelperTxt.isDisplayed());
        Assert.assertEquals("Enter a bank name", bankNameHelperTxt.getText());
    }

    public void assertBankAccountBankNameHelperTxt() {
        Assert.assertTrue(bankNameHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain at least 5 characters", bankNameHelperTxt.getText());
    }


    @FindBy(id = "bankaccount-routingNumber-input")
    WebElement routingNumberInputField;  //=9 characters

    public void assertBankAccountRoutingNumberInputField() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertTrue(routingNumberInputField.isEnabled()); //Check if it is necessary
    }

    public void routingNumberInputFieldSendKeys(String routingNo) {
        routingNumberInputField.clear();
        routingNumberInputField.sendKeys(routingNo);
    }


    @FindBy(id = "bankaccount-routingNumber-input-helper-text")
    WebElement routingNumberHelperTxt;  //Enter a valid bank routing number
    //Must contain a valid routing number

    public void assertErrorMsgEmptyRoutingNumberInputField() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertEquals("Enter a valid bank routing number", routingNumberHelperTxt.getText());
    }

    public void assertErrorMsgRoutingNumber() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertEquals("Must contain a valid routing number", routingNumberHelperTxt.getText());
        //Strictly more or less than 9 characters.
    }

    @FindBy(id = "bankaccount-accountNumber-input")
    WebElement accountNumberInputField;

    public void assertAccountNumberInputField() {
        Assert.assertTrue(accountNumberInputField.isDisplayed());
        Assert.assertTrue(accountNumberInputField.isEnabled());
    }

    public void accountNumberInputFieldSendKeys(String accountNumber) {
        accountNumberInputField.clear();
        accountNumberInputField.sendKeys(accountNumber);
        //  accountNumberInputField.sendKeys(Integer.toString(accountNumber));
    }

    @FindBy(id = "bankaccount-accountNumber-input-helper-text")
    WebElement accountNumberHelperTxt;  //Enter a valid bank account number
    //Must contain at least 9 digits
    //Must contain no more than 12 digits

    public void assertEmptyAccountNoHelperTxt() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Enter a valid bank account number", accountNumberHelperTxt.getText());
    }

    public void assertAccountNoHelperTxtMinimumValue() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain at least 9 digits", accountNumberHelperTxt.getText());
    }

    public void assertAccountNoHelperTxtMaximumValue() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain no more than 12 digits", accountNumberHelperTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/form/div[4]/div/button")
    WebElement saveButton;  //same class name for multiple buttons

    public void assertAndClickSaveButton() {
        Assert.assertTrue(saveButton.isDisplayed());
        Assert.assertTrue(saveButton.isEnabled());
        // Assert.assertEquals("Save", saveButton.getText());
        //todo check with team
        saveButton.click();
    }

    public void assertNewBankAccountURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.qacademy.rs/bankaccounts/new");
    }
}
