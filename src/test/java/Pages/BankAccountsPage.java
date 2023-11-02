package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankAccountsPage extends BaseTest {
    public BankAccountsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div[1]/h2")
    WebElement bankAccountsTitle;  //Bank Accounts

    public void assertBankAccountTitle() {
        Assert.assertTrue(bankAccountsTitle.isDisplayed());
        Assert.assertEquals("Bank Accounts", bankAccountsTitle.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li/div/div[1]/p")  //as12#
    WebElement userBankAccount;  //todo assert bank account equals one on registration form - ask the Team how

    public void assertUserBankAccount() {
        Assert.assertTrue(userBankAccount.isDisplayed());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div[2]/a")  //same again, on this pg for Create and Delete --> MuiButton-label
    WebElement createBtn;  //Create

    public void assertCreateBtn() {
        Assert.assertTrue(createBtn.isDisplayed());
        Assert.assertTrue(createBtn.isEnabled());
        Assert.assertEquals("Create", createBtn.getText());
    }

    public void clickCreateBtn() {
        createBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li/div/div[2]/button")  //Delete
    WebElement deleteBtn;

    public void assertDeleteBtn() {
        Assert.assertTrue(deleteBtn.isDisplayed());
        Assert.assertTrue(deleteBtn.isEnabled());
        Assert.assertEquals("Delete", deleteBtn.getText());
    }

    public void clickDeleteBtn() {
        deleteBtn.click();
    }

}
