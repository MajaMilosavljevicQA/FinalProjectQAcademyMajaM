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

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/h1")
    public WebElement signInSignUpTxt;  // same for Sign in and for Sign up

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/p/a")
    public WebElement qacademyLogo;


        //////////*********////////
    public void assertRWALogo() {
        Assert.assertTrue(realWorldAppLogo.isDisplayed());
    }

    public void assertSignInTxt() {
        Assert.assertTrue(signInSignUpTxt.isDisplayed());
        Assert.assertEquals("Sign in", signInSignUpTxt.getText());
    }

    public void assertQacademyLogo() {
        Assert.assertTrue(qacademyLogo.isDisplayed());
    }
    public void clickOnQacademyLogo() {
        qacademyLogo.click();
    }

}
