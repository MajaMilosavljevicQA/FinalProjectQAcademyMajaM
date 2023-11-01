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

    @FindBy(linkText = "Have an account? Sign In")
    WebElement haveAnAccountTxt;

    ////////////////****************//////////

    public void assertFirstNameField() {
        Assert.assertTrue(firstNameInputField.isDisplayed());
    }

    public void assertFirstNameHelperTxt() {
        lastNameInputField.click();
        Assert.assertTrue(firstNameErrorMsg.isDisplayed());
        Assert.assertEquals("First Name is required", firstNameErrorMsg.getText());
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
        Assert.assertEquals("Last Name is required", lastNameErrorMsg.getText());
    }

    public void assertPasswordEmptyFieldErrorMsg() {
        passwordInputField.click();
        usernameInputField.click();
        Assert.assertTrue(passwordErrorMsg.isDisplayed());
        Assert.assertEquals("Enter your password", passwordErrorMsg.getText());
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
        Assert.assertEquals("Confirm your password", confirmPasswordErrorMsg.getText());
    }


    public void assertSignUpButton() {
        Assert.assertTrue(singUpButton.isDisplayed());
    }

    public void signUpButtonClick() {
        singUpButton.click();
    }

    public void assertHaveAnAccountTxt() {
        Assert.assertTrue(haveAnAccountTxt.isDisplayed());
        Assert.assertEquals("Have an account? Sign In", haveAnAccountTxt.getText());
    }

    public void haveAnAccountClick() {
        haveAnAccountTxt.click();
    }


}
