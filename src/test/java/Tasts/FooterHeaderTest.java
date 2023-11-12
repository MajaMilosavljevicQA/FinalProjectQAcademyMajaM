package Tasts;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterHeaderTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
    }

    @Test(priority = 10)
    public void clickQAcademyLogoAssertUrlNotSignedIn() throws InterruptedException {
        scroll(0, 500);
        headerFooterLogosPage.assertQacademyLogo();
        headerFooterLogosPage.clickOnQacademyLogo();
        Thread.sleep(1000);
        headerFooterLogosPage.switchTab(1);
        Assert.assertEquals( driver.getCurrentUrl(), "https://qacademy.rs/");
    }

    @Test (priority = 20)
    public void inspectHeaderAndFooterWhenSignedIn() throws InterruptedException {
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.clickSignInButton();
        sidebarPage.assertBurgerBtn();
        sidebarPage.clickBurgerBtn();
        homePage.assertRWALink();
        headerFooterLogosPage.assertNewTransactionBtn();
        headerFooterLogosPage.clickNewTransactionBtnAndAssertURL();
        driver.navigate().back();
        homePage.clickRWALogoLink();
        homePage.realWorldAppURLWhenClickedUpon();
        headerFooterLogosPage.assertBellNotificationIcon();
        headerFooterLogosPage.clickBellNotificationIcon();
        notificationsPage.assertNotificationPageURL();  //Test passes till this point
        Actions actions = new Actions(driver);  //Inner scroll/slider does not scroll to element
        scroll(0, 500);  //Scrolls only outer slider
        actions.moveToElement(notificationsPage.qacademyLogo);
        actions.perform();  //todo ask team about solution
        Thread.sleep(500);
        headerFooterLogosPage.assertQacademyLogo();
        headerFooterLogosPage.clickOnQacademyLogo();
        Thread.sleep(1000);
        headerFooterLogosPage.switchTab(1);
        Assert.assertEquals( driver.getCurrentUrl(), "https://qacademy.rs/");
    }
}
