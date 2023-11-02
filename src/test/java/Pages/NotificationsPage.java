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
        Assert.assertEquals("No + \n +Notifications", notificationPgTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div/div[2]/div/svg")
    WebElement notificationsPgImg;

    public void assertNotificationPgImg() {
        Assert.assertTrue(notificationsPgImg.isDisplayed());
    }
}
