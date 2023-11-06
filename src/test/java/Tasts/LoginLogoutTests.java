package Tasts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLogoutTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
    }


    @Test(priority = 10)
    public void assertElementsOnLoginPg() {
        headerFooterLogos.assertRWALogo();
        loginPage.assertSignInTxt();
        loginPage.assertDontHaveAccountTxt();
        loginPage.assertSignInButton();
        loginPage.assertUsernameField();
        loginPage.assertPasswordInputField();
        loginPage.assertRememberMeCheckBox();
        loginPage.rememberMe();
        headerFooterLogos.assertQacademyLogo();
    }

    @Test(priority = 11)
    public void validSignInRememberMeChekedAndLogout() {
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.assertRememberMeCheckBox();
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();
        sidebarPage.assertLogoutLink();
        sidebarPage.clickLogoutLink();
        //todo get URL and assert https://app.qacademy.rs/signin
    }

    @Test(priority = 20)
    public void userNotSignedUpTriesToSingInWithValidCredentials() {
        loginPage.usernameField("Maja");
        loginPage.passwordField("1!Qa");
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();
        loginPage.assertErrorMsgSignIn();
    }

 }
