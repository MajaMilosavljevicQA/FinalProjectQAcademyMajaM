package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransactionCompletePage extends BaseTest {

    public TransactionCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[5]/span/span[2]/span")
    WebElement completeTxt;

    public void assertCompleteTxt() {
        Assert.assertTrue(completeTxt.isDisplayed());
        Assert.assertEquals("Complete", completeTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/div[2]/div/div/h2")
    WebElement requestedOrPaidFromUserTxt;

    public void assertRequestAmountFromUser() {
        Assert.assertTrue(requestedOrPaidFromUserTxt.isDisplayed());   //"Requested " + \n + "$" + amountDollar + \n + "for " + \n + noteTransaction  //todo assert Equals
    }

    public void assertPaidAmountToUser() {
        Assert.assertTrue(requestedOrPaidFromUserTxt.isDisplayed());   //"Paid " + \n + "$" + amountDollar + \n + "for " + \n + noteTransaction  //todo assert Equals
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/div[3]/div/div[1]/a")
    WebElement returnToTransactionsBtn;

    public void assertReturnToTransactionsBtn() {
        Assert.assertTrue(returnToTransactionsBtn.isDisplayed());
        Assert.assertTrue(returnToTransactionsBtn.isEnabled());
        Assert.assertEquals("Return To Transactions", returnToTransactionsBtn.getText());
    }

    public void returnToTransactionsBtnClick() {  //Returns to HomePg https://app.qacademy.rs/
        returnToTransactionsBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/div[3]/div/div[2]/button")
    WebElement createAnotherTransactionBtn;

    public void assertCreateAnotherTransactionBtn() {
        Assert.assertTrue(createAnotherTransactionBtn.isDisplayed());
        Assert.assertTrue(createAnotherTransactionBtn.isEnabled());
        Assert.assertEquals("Create Another Transaction", createAnotherTransactionBtn.getText());
    }

    public void createAnotherTransactionBtnClick() {
        createAnotherTransactionBtn.click();    //returns to Select Contact --> URL: https://app.qacademy.rs/transaction/new
    }
}
