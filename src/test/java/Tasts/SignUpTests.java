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
        signUpRegistrationPage.assertUsernameInputField();
        signUpRegistrationPage.assertPasswordInputField();
        signUpRegistrationPage.assertConfirmPasswordInputField();
        signUpRegistrationPage.assertSignUpButton();
        signUpRegistrationPage.assertHaveAnAccountTxt();
        Thread.sleep(1000);
        signUpRegistrationPage.haveAnAccountClick();       //At this point, test passes even though it doesn't click the link
       // signUpRegistrationPage.haveAnAccountClick();     //BUG -->> Need to click two times on same link while first atempt in order for the test to pass.
        Thread.sleep(1500);
        String urlSignIn = driver.getCurrentUrl();
        //System.out.println(urlSignIn);
        Assert.assertEquals(urlSignIn,"https://app.qacademy.rs/signin");  //Test fails --> /signup
    }

    @Test(priority = 11)
    public void signUpWithValidCredentials () throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("SignUp-Registration")-1; i++) {
            String validFirstName = excelReader.getStringData("SignUp-Registration", i, 0);
            String validLastName = excelReader.getStringData("SignUp-Registration", i, 1);
            String validUsername = excelReader.getStringData("SignUp-Registration", i, 2);
            String validPassword = excelReader.getStringData("SignUp-Registration", i, 3);
            String validConfirmPassword = excelReader.getStringData("SignUp-Registration", i, 4);
            signUpRegistrationPage.firstNameField(validFirstName);
            signUpRegistrationPage.lastNameField(validLastName);
            signUpRegistrationPage.usernameField(validUsername);
            signUpRegistrationPage.passwordField(validPassword);
            signUpRegistrationPage.confirmPasswordInputField(validConfirmPassword);
            signUpRegistrationPage.assertSignUpButton();
            signUpRegistrationPage.signUpButtonClick();
          //  loginPage.clickOnDontHaveAccountSignUp();  // BUG --> Does not work
            //In order to check this test, I will try to override it to confirm excel data
          //  driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().to("https://app.qacademy.rs/signup");
        }

    }

    @Test(priority = 12)
    public void signUpWithInvalidCredentials () throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("SignUp-Registration")-1; i++) {
            String invalidFirstName = excelReader.getStringData("SignUp-Registration", i, 5);
            String invalidLastName = excelReader.getStringData("SignUp-Registration", i, 6);
            String invalidUsername = excelReader.getStringData("SignUp-Registration", i, 7);
            String invalidPassword = excelReader.getStringData("SignUp-Registration", i, 8);
            String invalidConfirmPassword = excelReader.getStringData("SignUp-Registration", i, 9);
            signUpRegistrationPage.firstNameField(invalidFirstName);
            signUpRegistrationPage.lastNameField(invalidLastName);
            signUpRegistrationPage.usernameField(invalidUsername);
            signUpRegistrationPage.passwordField(invalidPassword);
            signUpRegistrationPage.confirmPasswordInputField(invalidConfirmPassword);
            signUpRegistrationPage.assertSignUpButton();
            signUpRegistrationPage.signUpButtonClick();
            //todo assert error msg, + signUpButton false is enabled

            //  loginPage.clickOnDontHaveAccountSignUp();  // BUG --> Does not work
            //In order to check this test, I will try to override it to confirm excel data
            //  driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().to("https://app.qacademy.rs/signup");
        }

        //todo try catch for helpertxt error msg

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

    @Test (priority = 30)
    public void testLinkTxtHaveAnAccount() throws InterruptedException {
        scroll(0, 500);
        signUpRegistrationPage.haveAnAccountClick(); // BUG -->> Need to click two times on same link while first atempt.
      //  signUpRegistrationPage.haveAnAccountClick();
        Thread.sleep(3000);
        scroll(0,500);
        loginPage.clickOnDontHaveAccountSignUp();  // BUG -->> Need to click two times on same link while first atempt.
     //   loginPage.clickOnDontHaveAccountSignUp();
    }

}
