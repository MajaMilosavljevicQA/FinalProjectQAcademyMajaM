package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderFooterLogos extends BaseTest {
    public HeaderFooterLogos() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "jss3")
    public WebElement realWorldAppLogo;

    public void assertRWALogo() {
        Assert.assertTrue(realWorldAppLogo.isDisplayed());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/p/a")
    public WebElement qacademyLogo;

    public void assertQacademyLogo() {
        Assert.assertTrue(qacademyLogo.isDisplayed());
    }
    public void clickOnQacademyLogo() {
        qacademyLogo.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[1]/a[1]")
    WebElement newTransactionButton;

    public void assertNewTransactionBtn() {
        Assert.assertTrue(newTransactionButton.isDisplayed());
        Assert.assertTrue(newTransactionButton.isEnabled());
        Assert.assertEquals(" New", newTransactionButton.getText());
    }

    public void clickNewTransactionBtn() {
        newTransactionButton.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[1]/a[2]")
    WebElement bellNotificationIcon;

    public void assertBellNotificationIcon() {
        Assert.assertTrue(bellNotificationIcon.isDisplayed());
        Assert.assertTrue(bellNotificationIcon.isEnabled());
    }

    public void clickBellNotificationIcon() {
        bellNotificationIcon.click();
    }

}
