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
        headerFooterLogos.assertQacademyLogo();
        headerFooterLogos.clickOnQacademyLogo();
        Thread.sleep(1000);
        headerFooterLogos.switchTab(1);
        Assert.assertEquals( driver.getCurrentUrl(), "https://qacademy.rs/");
    }
}
