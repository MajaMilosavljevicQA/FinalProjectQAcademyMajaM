package Tasts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
    }

    @Test(priority = 10)
    public void clickQAcademyLogoAssertUrl() throws InterruptedException {
        headerFooterLogosPage.assertQacademyLogo();
        headerFooterLogosPage.clickOnQacademyLogo();
        Thread.sleep(1000);
        headerFooterLogosPage.switchTab(1);
        Assert.assertEquals( driver.getCurrentUrl(), "https://qacademy.rs/");
    }
}
