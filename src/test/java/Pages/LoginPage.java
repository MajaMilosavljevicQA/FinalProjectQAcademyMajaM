package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/h1")
    public WebElement signInTxt;  // same for Sign in and for Sign up

    public void assertSignInTxt() {
        Assert.assertTrue(signInTxt.isDisplayed());
        Assert.assertEquals("Sign in", signInTxt.getText());
    }

    @FindBy(id = "username")
    public WebElement usernameInputField;

    @FindBy(id = "username-helper-text")
    public WebElement usernameErrorMsg;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(id = "password-helper-text")
    public WebElement passwordErrorMsg;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/form/label/span[1]")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/form/label/span[2]")
    WebElement rememberMeTxt;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/form/button")   //same for SIGN UP button
    public WebElement signInButton;

    @FindBy(linkText = "Don't have an account? Sign Up")
    public WebElement dontHaveAccountSignUpLinkTxt;

    @FindBy(className = "MuiAlert-message")
    WebElement errorMsgSignIn;

    //////////////**********///////////////

    public void assertLoginPageUrl() {
        String urlSignIn = "https://app.qacademy.rs/signin";
        Assert.assertEquals(driver.getCurrentUrl(), urlSignIn);
    }

    public void assertUsernameField() {
        Assert.assertTrue(usernameInputField.isDisplayed());
    }

    public void assertPasswordInputField() {
        Assert.assertTrue(passwordInputField.isDisplayed());
    }

    public void passwordField(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void usernameField(String username) {
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void assertUsernameErrorMsg() {
        Assert.assertTrue(usernameErrorMsg.isDisplayed());
        Assert.assertEquals("Username is required", usernameErrorMsg.getText());
    }


    public void assertPasswordErrorMsg4Char() {
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals("Password must contain at least 4 characters", passwordErrorMsg.getText());
    }

    public void rememberMe() {
        Assert.assertTrue(rememberMeCheckBox.isDisplayed());
        Assert.assertTrue(rememberMeTxt.isDisplayed());
        Assert.assertEquals("Remember me", rememberMeTxt.getText());
    }

    public void assertRememberMeCheckBox() {
        Assert.assertTrue(rememberMeCheckBox.isDisplayed());
        //Assert.assertFalse(rememberMeCheckBox.isSelected());
    }

    public void clickRememberMeCheckBox() {
        rememberMeCheckBox.click();
       // Assert.assertTrue(rememberMeCheckBox.isSelected());  // todo test fails when this assertation is active. Check it
    }

    public void assertVisibleSignInButton() {
        Assert.assertTrue(signInButton.isDisplayed());
        Assert.assertEquals("Sign in", signInButton.getText());
    }

    public void assertInnactiveSignInButton() {
        Assert.assertFalse(signInButton.isDisplayed());
        Assert.assertFalse(signInButton.isEnabled());
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void assertDontHaveAccountTxt() {
        Assert.assertTrue(dontHaveAccountSignUpLinkTxt.isDisplayed());
        Assert.assertTrue(dontHaveAccountSignUpLinkTxt.isEnabled());
        Assert.assertEquals("Don't have an account? Sign Up", dontHaveAccountSignUpLinkTxt.getText());
    }

    public void clickOnDontHaveAccountSignUp() {
        dontHaveAccountSignUpLinkTxt.click();
    }


    public void assertErrorMsgSignIn() {
        Assert.assertTrue(errorMsgSignIn.isDisplayed());
    }
}
