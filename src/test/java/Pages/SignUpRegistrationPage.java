package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpRegistrationPage extends BaseTest {

    public SignUpRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/h1")
    WebElement signUpTxt;

    @FindBy(id = "firstName")
    WebElement firstNameInputField;

    @FindBy(id = "firstName-helper-text")
    WebElement firstNameErrorMsg;

    @FindBy(id = "lastName")
    WebElement lastNameInputField;

    @FindBy(id = "lastName-helper-text")
    WebElement lastNameErrorMsg;

    @FindBy(id = "username")
    public WebElement usernameInputField;

    @FindBy(id = "username-helper-text")
    public WebElement usernameErrorMsg;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(id = "password-helper-text")
    public WebElement passwordErrorMsg;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordInputField;

    @FindBy(id = "confirmPassword-helper-text")
    WebElement confirmPasswordErrorMsg;    //todo Confirm your password && Password does not match

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/form/button/span[1]")
    WebElement singUpButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/form/div[6]/div")  ////*[@id="root"]/div/main/div[1]/form/div[6]/div/a
    WebElement haveAnAccountTxt;  //Have an account? Sign In  //xpath = "//a[@href='/signin']"

    ////////////////****************//////////

    public void assertRegistrationPageURL() {
        String urlSignup = "https://app.qacademy.rs/signup";
        Assert.assertEquals(driver.getCurrentUrl(), urlSignup);
    }

    public void assertSignUpTxt() {
        Assert.assertTrue(signUpTxt.isDisplayed());
        Assert.assertEquals(signUpTxt.getText(), "Sign Up");
    }

    public void assertFirstNameField() {
        Assert.assertTrue(firstNameInputField.isDisplayed());
    }

    public void assertFirstNameHelperTxt() {
        lastNameInputField.click();
        Assert.assertTrue(firstNameErrorMsg.isDisplayed());
        Assert.assertEquals(firstNameErrorMsg.getText(), "First Name is required");
    }

    public void firstNameField(String firstName) {
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
    }

    public void assertLastNameField() {
        Assert.assertTrue(lastNameInputField.isDisplayed());
    }

    public void lastNameField(String lastName) {
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void assertLastNameHelperTxt() {
        lastNameInputField.click();
        firstNameInputField.click();
        Assert.assertTrue(lastNameErrorMsg.isDisplayed());
        Assert.assertEquals(lastNameErrorMsg.getText(), "Last Name is required");
    }

    public void assertUsernameInputField() {
        Assert.assertTrue(usernameInputField.isDisplayed());
        Assert.assertTrue(usernameInputField.isEnabled());
    }


    public void usernameField(String username) {
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void assertUsernameHelperTxt() {
        usernameInputField.click();
        passwordInputField.click();
        Assert.assertTrue(usernameErrorMsg.isDisplayed());
        Assert.assertEquals(usernameErrorMsg.getText(), "Username is required");
    }

    public void assertPasswordInputField() {
        Assert.assertTrue(passwordInputField.isDisplayed());
        Assert.assertTrue(passwordInputField.isEnabled());
    }

    public void passwordField(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }


    public void assertPasswordEmptyFieldErrorMsg() {
        passwordInputField.click();
        usernameInputField.click();
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals(passwordErrorMsg.getText(), "Enter your password");
    }

    public void assertPasswordErrorMsg4Char(String under4CharPassword) {
        passwordInputField.sendKeys(under4CharPassword);
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals("Password must contain at least 4 characters", passwordErrorMsg.getText());
    }

    public void assertConfirmPasswordInputField() {
        Assert.assertTrue(confirmPasswordInputField.isDisplayed());
    }

    public void confirmPasswordInputField(String password) {
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(password);
    }

    public void assertConfirmPasswordHelperTxt() {
        confirmPasswordInputField.click();
        passwordInputField.click();
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals(confirmPasswordErrorMsg.getText(), "Confirm your password");
    }

    public void assertPasswordDoesNotMatchHelperTxt() {
        confirmPasswordInputField.click();
        passwordInputField.click();
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals(confirmPasswordErrorMsg.getText(), "Password does not match");
    }


    public void assertSignUpButton() {
        Assert.assertTrue(singUpButton.isDisplayed());
    }

    public void signUpButtonClick() {
        singUpButton.click();
    }

    public void assertHaveAnAccountTxt() {
        Assert.assertTrue(haveAnAccountTxt.isDisplayed());
        Assert.assertEquals(haveAnAccountTxt.getText(), "Have an account? Sign In");
        Assert.assertTrue(haveAnAccountTxt.isEnabled());
    }

    public void haveAnAccountClick() {
      haveAnAccountTxt.click();
    }


}
