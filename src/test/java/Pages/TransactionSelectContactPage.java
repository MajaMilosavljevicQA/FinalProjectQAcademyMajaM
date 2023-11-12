package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransactionSelectContactPage extends BaseTest {

    public TransactionSelectContactPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[1]/span/span[2]")
    WebElement selectContactTxt;

    public void assertSelectContactTxt() {
        Assert.assertTrue(selectContactTxt.isDisplayed());
        Assert.assertEquals(selectContactTxt.getText(),"Select Contact");
    }

    @FindBy(id = "user-list-search-input")
    WebElement searchInputField;

    public void assertSearchInputField() {
        Assert.assertTrue(searchInputField.isDisplayed());
        Assert.assertTrue(searchInputField.isEnabled());
    }

    public void searchInputFieldSendKeys(String transactionUserName) {
        searchInputField.clear();
        searchInputField.sendKeys(transactionUserName);  //  Genije  password --> 1! #q
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/ul/li[1]/div[2]")
    WebElement peraKojotGenije;

    public void assertGenijeUserName() {
        Assert.assertTrue(peraKojotGenije.isDisplayed());
    }

    public void clickGenijeUserTransaction() {
        peraKojotGenije.click();
    }

    public void transactionPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.qacademy.rs/transaction/new");
    }
}
