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

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[1]/span/span[1]/svg/text")
    WebElement stepOne;

    public void assertStepOneTxt() {
        Assert.assertTrue(stepOne.isDisplayed());
        Assert.assertEquals("1", stepOne.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div[1]/span/span[2]/span")
    WebElement selectContactTxt;

    public void assertSelectContactTxt() {
        Assert.assertTrue(selectContactTxt.isDisplayed());
        Assert.assertEquals("Select Contact", selectContactTxt.getText());
    }

    @FindBy(id = "user-list-search-input")
    WebElement searchInputField;

    public void assertSearchInputField() {
        Assert.assertTrue(searchInputField.isDisplayed());
        Assert.assertTrue(searchInputField.isEnabled());
    }

    public void searchInputFieldSendKeys(String transactionUserName) {
        searchInputField.clear();
        searchInputField.sendKeys(transactionUserName);  //markomirtic  mmirtic
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[2]/ul/li[1]/div[2]/p/span/span/span[1]")
    WebElement markoMirtic;

    public void assertMarkoMirticUserName() {
        Assert.assertTrue(markoMirtic.isDisplayed());
    }

    public void clickMarkoMirticUserTransaction() {
        markoMirtic.click();
    }


}
