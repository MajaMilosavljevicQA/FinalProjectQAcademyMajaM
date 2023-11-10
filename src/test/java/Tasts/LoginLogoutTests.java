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
    public void assertElementsOnLoginPgAndClickSignUpLink() {
        loginPage.assertLoginPageUrl();
        headerFooterLogos.assertRWALogo();
        loginPage.assertSignInTxt();
        loginPage.assertUsernameField();
        loginPage.assertPasswordInputField();
        loginPage.assertRememberMeCheckBox();
        loginPage.rememberMe();
        headerFooterLogos.assertQacademyLogo();
        loginPage.assertDontHaveAccountTxt();
        loginPage.clickOnDontHaveAccountSignUp();  //in reality it does not click
        signUpRegistrationPage.assertRegistrationPageURL();  //actual url --> /signin, expected /signup  FAILS
    }

    @Test(priority = 11)
    public void validSignInRememberMeChekedAndLogout() throws InterruptedException {
        loginPage.assertLoginPageUrl();
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.assertRememberMeCheckBox();
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();
        sidebarPage.assertLogoutLink();
        sidebarPage.clickLogoutLink();
        Thread.sleep(2000);
        loginPage.assertLoginPageUrl();
    }

    @Test(priority = 12)
    public void validLoginExcelData() throws InterruptedException {
        for (int i = 1; i < excelReader.getLastRow("Login-SignIn")-1; i++) {
            String validUsername = excelReader.getStringData("Login-SignIn", i, 0);
            String validPassword = excelReader.getStringData("Login-SignIn", i, 1);
            loginPage.usernameField(validUsername);
            loginPage.passwordField(validPassword);
            loginPage.clickSignInButton();
           // homePage.assertHeaderGetStartedRWA();  --> this will pass only once
          //  homePage.assertPasusGetStartedRWA(); //todo ask team how to resolve this
            homePage.assertAndClickNextButton();
            homePage.assertHeaderCreateBankAccount();
            homePage.assertAndClickSaveButton();  //BUG --> required two clicks
            homePage.assertAndClickSaveButton();  //BUG --> required two clicks
            homePage.assertBankAccountBankNameInputField();
            homePage.assertBankAccountEmptyBankNameHelperTxt();
          //  homePage.bankNameInputFieldSendKeys("a");
          //  homePage.assertBankAccountBankNameHelperTxt();
            String validBankName = excelReader.getStringData("Login-SignIn", i, 4);
            String validRoutingNumber = excelReader.getStringData("Login-SignIn", i, 5);
            String validAccNumber = excelReader.getStringData("Login-SignIn", i, 6);
            //int validAccNumber = excelReader.getIntegerData("Login-SignIn", i, 6);
            homePage.bankNameInputFieldSendKeys(validBankName);
         //   homePage.routingNumberInputFieldSendKeys("1");
         //   homePage.accountNumberInputtFieldSendKeys("m");
         //   homePage.assertErrorMsgRoutingNumber();
            homePage.routingNumberInputFieldSendKeys(validRoutingNumber);
        //    homePage.assertAccountNoHelperTxtMinimumValue();
          //  homePage.accountNumberInputtFieldSendKeys(1234567890123); --> Int data too large. //todo find a solution
          //  homePage.assertAccountNoHelperTxtMaximumValue();
            homePage.accountNumberInputtFieldSendKeys(validAccNumber);
            Thread.sleep(1000);
            homePage.assertAndClickSaveButton();
            homePage.assertFinishedHeading3rdPopup();
            homePage.assertPassusTxt3rdPopup();
            homePage.assertAndClickDoneButton();
            Thread.sleep(1000);
            homePage.assertEveryoneLinkTab();
            sidebarPage.clickLogoutLink();
            Thread.sleep(1500);
        }
//Test can pass only once. Otherwise, you need to change data in Excel and redo Sign UP/Registration

    }

    @Test(priority = 20)
    public void userNotSignedUpTriesToSingInWithValidCredentials() {
        loginPage.usernameField("Maja");
        loginPage.passwordField("1!Qa");
        loginPage.clickRememberMeCheckBox();
        loginPage.clickSignInButton();
        loginPage.assertErrorMsgSignIn();
    }

    @Test(priority = 30)
    public void failToLoginLeavingAllFieldsEmpty() {
        loginPage.assertVisibleSignInButton();
        loginPage.clickSignInButton();
        loginPage.assertInnactiveSignInButton();
        loginPage.assertUsernameErrorMsg();
    }

 }
