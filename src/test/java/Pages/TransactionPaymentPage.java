package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransactionPaymentPage extends BaseTest {

    public TransactionPaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[3]/span/span[1]/svg/text")
    WebElement secondStepTxt;

    public void assertSecondStep() {
        Assert.assertTrue(secondStepTxt.isDisplayed());
        Assert.assertEquals("2", secondStepTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[3]/span/span[2]/span")
    WebElement paymentTxt;

    public void assertPaymentTxt() {
        Assert.assertTrue(paymentTxt.isDisplayed());
        Assert.assertEquals("Payment", paymentTxt.getText());
    }

    @FindBy(id = "amount")
    WebElement amountField;

    public void assertAmountField() {
        Assert.assertTrue(amountField.isDisplayed());
        // Assert.assertTrue(amountField.isEnabled());
    }

    public void amountFieldSendKeys(double amountDollar) {
        amountField.clear();
        amountField.sendKeys(Double.toString(amountDollar));
    }

    @FindBy(id = "transaction-create-amount-input-helper-text")
    WebElement amountFieldHelperTxt;

    public void assertEmptyAmountFieldTxt() {
        //Please enter a valid amount
        addANoteField.click();
        Assert.assertTrue(amountFieldHelperTxt.isDisplayed());
        Assert.assertEquals("Please enter a valid amount", amountFieldHelperTxt.getText());
    }

    @FindBy(id = "transaction-create-description-input")
    WebElement addANoteField;

    public void assertAddANoteField() {
        Assert.assertTrue(addANoteField.isDisplayed());
        //Assert.assertTrue(addANoteField.isEnabled());
    }

    public void addANoteSendKeys(String noteTransaction) {
        addANoteField.clear();
        addANoteField.sendKeys(noteTransaction);
    }

    @FindBy(id = "transaction-create-description-input-helper-text")
    WebElement addANoteHelperTxt;

    public void assertEmptyAddANoteField() {
        addANoteField.clear();
        addANoteField.click();
        amountField.click();
        Assert.assertTrue(addANoteField.isDisplayed());
        Assert.assertEquals("Please enter a note", addANoteHelperTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/div[2]/form/div[3]/div[1]/button/span[1]")
    WebElement requestBtn;

    public void assertRequestBtn() {
        Assert.assertTrue(requestBtn.isDisplayed());
        Assert.assertTrue(requestBtn.isEnabled());
        Assert.assertEquals("REQUEST", requestBtn.getText());
    }

    public void requestBtnClick() {
        requestBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/div[2]/form/div[3]/div[2]/button/span[1]")
    WebElement payBtn;

    public void assertPayBtn() {
        Assert.assertTrue(payBtn.isDisplayed());
        Assert.assertTrue(payBtn.isEnabled());
        Assert.assertEquals("PAY", payBtn.getText());
    }

    public void payBtnClick() {
        payBtn.click();
    }

}
