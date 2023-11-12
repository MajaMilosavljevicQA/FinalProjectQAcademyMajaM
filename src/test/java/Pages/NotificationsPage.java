package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationsPage extends BaseTest {

    public NotificationsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/h2")
    WebElement notificationsTitle;

    public void assertNotificationsTitle() {
        Assert.assertTrue(notificationsTitle.isDisplayed());
        Assert.assertEquals("Notifications", notificationsTitle.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div/div[1]/h2")
    WebElement notificationPgTxt;

    public void assertEmptyNotificationTxt() {
        Assert.assertTrue(notificationPgTxt.isDisplayed());
        Assert.assertEquals( notificationPgTxt.getText(), "No Notifications");
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div/div[2]")
    WebElement notificationsPgImg;

    public void assertNotificationPgImg() {
        Assert.assertTrue(notificationsPgImg.isDisplayed());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[1]/a[2]/span[1]/span/span")
    WebElement notificationBadge;

    public void assertNotificationBadge() {
        Assert.assertTrue(notificationBadge.isDisplayed());
        //Assert.assertEquals();  --> todo ask team how to assert badge number
    }

    public void assertNotificationPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.qacademy.rs/notifications");
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/p/a")
    public WebElement qacademyLogo;

    public void assertQacademyLogo() {
        Assert.assertTrue(qacademyLogo.isDisplayed());
    }
    public void clickOnQacademyLogo() {
        qacademyLogo.click();
    }


}
