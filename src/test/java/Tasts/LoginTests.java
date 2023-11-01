package Tasts;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
    }


    @Test(priority = 10)
    public void assertElementsOnLoginPg() {
        headerFooterLogos.assertRWALogo();
        headerFooterLogos.assertSignInTxt();
        loginPage.assertDontHaveAccountTxt();
        loginPage.assertSignInButton();
        loginPage.assertUsernameField();
        loginPage.assertPasswordInputField();
        loginPage.rememberMe();
        headerFooterLogos.assertQacademyLogo();
    }

    @Test(priority = 11)
    public void validSignInRememberMeCheked() {
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();


    }

     @Test(priority = 20)
     public void userNotSignedUpTriesToSingInWithValidCredentials() {
        loginPage.usernameField("Maja");
        loginPage.passwordField("1!Qa");
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();
        loginPage.assertErrorMsgSignIn();
     }

     @Test
    public void test() {

     }
}
