package Tasts;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationsTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.clickSignInButton();
    }

    @Test(priority = 10)
    public void inspectNotificationsAfterUserDemandsMoneyFromAnotherUser() {
        sidebarPage.assertNotificationLink();
        sidebarPage.clickNotificartionLink();
        notificationsPage.assertNotificationsTitle();
        notificationsPage.assertNotificationPgImg();
        notificationsPage.assertEmptyNotificationTxt();
        notificationsPage.assertNotificationBadge();


    }

}
