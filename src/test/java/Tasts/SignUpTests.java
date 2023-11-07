package Tasts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signup");
    }

    @Test(priority = 10)
    public void assertSignUpPgElementsAndClickOnHaveAnAccountLink() throws InterruptedException {
        headerFooterLogos.assertRWALogo();
        String urlSignUp = driver.getCurrentUrl();
        Assert.assertEquals(urlSignUp, "https://app.qacademy.rs/signup");
        signUpRegistrationPage.assertSignUpTxt();
        headerFooterLogos.assertQacademyLogo();
        signUpRegistrationPage.assertFirstNameField();
        signUpRegistrationPage.assertLastNameField();
        signUpRegistrationPage.assertUsernameInputField(); //same element for login and registration pg.
        signUpRegistrationPage.assertPasswordInputField(); //same element for login and registration pg.
        signUpRegistrationPage.assertConfirmPasswordInputField();
        signUpRegistrationPage.assertSignUpButton();
        signUpRegistrationPage.assertHaveAnAccountTxt();
        Thread.sleep(1000);
        signUpRegistrationPage.haveAnAccountClick();       //At this point, test passes even though it doesn't click the link
        Thread.sleep(1500);
        String urlSignIn = driver.getCurrentUrl();
        //System.out.println(urlSignIn);
        Assert.assertEquals(urlSignIn,"https://app.qacademy.rs/signin");  //Test fails --> /signup
    }

    @Test(priority = 20)
    public void assertHelperTxt() {
        signUpRegistrationPage.assertFirstNameHelperTxt();
        signUpRegistrationPage.assertLastNameHelperTxt();
        signUpRegistrationPage.assertUsernameHelperTxt();
        signUpRegistrationPage.assertPasswordEmptyFieldErrorMsg();
        signUpRegistrationPage.assertPasswordErrorMsg4Char("1");
        signUpRegistrationPage.assertConfirmPasswordHelperTxt();
        signUpRegistrationPage.confirmPasswordInputField("I");
        signUpRegistrationPage.assertPasswordDoesNotMatchHelperTxt();
    }

}
