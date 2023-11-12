package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
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

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li[1]/div[2]/span")
    WebElement temporaryPeraKojotRecievedNotification;

    public void assertTemporaryPeraKojotRecievedTxt() {
        Assert.assertTrue(temporaryPeraKojotRecievedNotification.isDisplayed());
        Assert.assertEquals(temporaryPeraKojotRecievedNotification.getText(), "Pera Kojot received payment.");
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li[1]/button")
    WebElement temporaryDismissFirstButton;

    public void assertDismissBtn() {
        Assert.assertTrue(temporaryDismissFirstButton.isDisplayed());
        Assert.assertEquals(temporaryDismissFirstButton.getText(), "DISMISS");
    }

    public void clickFirstDismissBtn() {
        temporaryDismissFirstButton.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li[8]/div[2]")
    WebElement temporaryLastMajaMRequestedPaymentNotification;

    public void assertTemporaryMajaMReqPayNotifTxt() {
        Assert.assertTrue(temporaryLastMajaMRequestedPaymentNotification.isDisplayed());
        Assert.assertEquals(temporaryLastMajaMRequestedPaymentNotification.getText(), "Maja M requested payment.");
    }
    //todo --> ask team how to assert different types of icons for payments (red and green)

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li[8]/button")
    WebElement temporaryLastDismissBtnMajaM;

    public void assertLastTemporaryDismissBtnMajaM() {
        Assert.assertTrue(temporaryLastDismissBtnMajaM.isDisplayed());
        Assert.assertEquals(temporaryLastDismissBtnMajaM.getText(), "DISMISS");
    }

    public void lastTemporaryDismissBtnClickMajaM() {
        temporaryLastDismissBtnMajaM.click();
    }


}
