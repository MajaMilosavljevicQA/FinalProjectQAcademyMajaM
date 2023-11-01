package Tasts;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signup");
    }

    @Test(priority = 10)
    public void assertSignUpPgElements() {
        headerFooterLogos.assertRWALogo();
        headerFooterLogos.assertSignInTxt();
        headerFooterLogos.assertQacademyLogo();
        signUpRegistrationPage.assertFirstNameField();
        signUpRegistrationPage.assertLastNameField();
        loginPage.assertUsernameField();
        loginPage.assertPasswordInputField();
        signUpRegistrationPage.assertConfirmPasswordInputField();
        signUpRegistrationPage.assertSignUpButton();
        signUpRegistrationPage.assertHaveAnAccountTxt();
    }

    @Test(priority = 30)
    public void test() {
        signUpRegistrationPage.assertPasswordEmptyFieldErrorMsg();
    }

}
