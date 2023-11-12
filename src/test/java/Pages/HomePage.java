package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/button")  //MuiTouchRipple-root
    //Steps only after Registration and first login
    WebElement nextButtonPopUp;     //todo inspect txt on buttons

    public void assertAndClickNextButton() {
        Assert.assertTrue(nextButtonPopUp.isDisplayed());
        Assert.assertTrue(nextButtonPopUp.isEnabled());
       // Assert.assertEquals("Next", nextButtonPopUp.getText()); // todo ask team about this
        nextButtonPopUp.click();
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/form/div[4]/div/button/span[1]")
    WebElement saveButton;  //same class name for multiple buttons

    public void assertAndClickSaveButton() {
        Assert.assertTrue(saveButton.isDisplayed());
        Assert.assertTrue(saveButton.isEnabled());
       // Assert.assertEquals("Save", saveButton.getText());
        //todo check with team
        saveButton.click();
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[3]/div/div[2]/button")
    ///html/body/div[2]/div[3]/div/div[3]/div/div[2]/button/span[2] --> span class Done
    WebElement doneButton; //thirdPopup-Finished

    public void assertAndClickDoneButton() {
        Assert.assertTrue(doneButton.isDisplayed());
        Assert.assertTrue(doneButton.isEnabled());
        //Assert.assertEquals("Done", doneButton.getText());
        //todo check with team
        doneButton.click();
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[1]/h2")
    WebElement getStartedWithRWAH2FirstPopup;  //Get Started with Real World App

    public void assertHeaderGetStartedRWA() {
        Assert.assertTrue(getStartedWithRWAH2FirstPopup.isDisplayed());
        Assert.assertEquals("Get Started with Real World App", getStartedWithRWAH2FirstPopup.getText());
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/p")
    WebElement pasusTxtGetStartedRWAFirstPopup;  //Real World App requires a Bank Account to perform transactions. +\n+ \n +
    // Click Next to begin setup of your Bank Account.

    public void assertPasusGetStartedRWA() {
        Assert.assertTrue(pasusTxtGetStartedRWAFirstPopup.isDisplayed());
        Assert.assertEquals("Real World App requires a Bank Account to perform transactions.+\n + \n +Click Next to begin setup of your Bank Account.", pasusTxtGetStartedRWAFirstPopup.getText());
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[1]/h2") //Create Bank Account
    WebElement createBankAccountSecondPopUpHeading;

    public void assertHeaderCreateBankAccount() {
        Assert.assertTrue(createBankAccountSecondPopUpHeading.isDisplayed());
        Assert.assertEquals("Create Bank Account", createBankAccountSecondPopUpHeading.getText());
    }

    @FindBy(id = "bankaccount-bankName-input")
    WebElement bankNameInputField;

    public void assertBankAccountBankNameInputField() {
        Assert.assertTrue(bankNameInputField.isDisplayed());
      //  Assert.assertTrue(bankNameInputField.isEnabled()); //Check if it is necessary
    }

    public void bankNameInputFieldSendKeys(String bankName) {
        bankNameInputField.clear();
        bankNameInputField.sendKeys(bankName);
    }

    @FindBy(id = "bankaccount-bankName-input-helper-text")
    WebElement bankNameHelperTxt;  // Enter a bank name

    //Must contain at least 5 characters
    public void assertBankAccountEmptyBankNameHelperTxt() {
        Assert.assertTrue(bankNameHelperTxt.isDisplayed());
        Assert.assertEquals("Enter a bank name", bankNameHelperTxt.getText());
    }

    public void assertBankAccountBankNameHelperTxt() {
        Assert.assertTrue(bankNameHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain at least 5 characters", bankNameHelperTxt.getText());
    }


    @FindBy(id = "bankaccount-routingNumber-input")
    WebElement routingNumberInputField;  //=9 characters

    public void assertBankAccountRoutingNumberInputField() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertTrue(routingNumberInputField.isEnabled()); //Check if it is necessary
    }

    public void routingNumberInputFieldSendKeys(String routingNo) {
        routingNumberInputField.clear();
        routingNumberInputField.sendKeys(routingNo);
    }


    @FindBy(id = "bankaccount-routingNumber-input-helper-text")
    WebElement routingNumberHelperTxt;  //Enter a valid bank routing number
    //Must contain a valid routing number

    public void assertErrorMsgEmptyRoutingNumberInputField() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertEquals("Enter a valid bank routing number", routingNumberHelperTxt.getText());
    }

    public void assertErrorMsgRoutingNumber() {
        Assert.assertTrue(routingNumberInputField.isDisplayed());
        Assert.assertEquals("Must contain a valid routing number", routingNumberHelperTxt.getText());
        //Strictly more or less than 9 characters.
    }

    @FindBy(id = "bankaccount-accountNumber-input")
    WebElement accountNumberInputField;

    public void assertAccountNoInputField() {
        Assert.assertTrue(accountNumberInputField.isDisplayed());
        Assert.assertTrue(accountNumberInputField.isEnabled());
    }

    public void accountNumberInputtFieldSendKeys(String accountNumber) {
        accountNumberInputField.clear();
        accountNumberInputField.sendKeys(accountNumber);
      //  accountNumberInputField.sendKeys(Integer.toString(accountNumber));
    }

    @FindBy(id = "bankaccount-accountNumber-input-helper-text")
    WebElement accountNumberHelperTxt;  //Enter a valid bank account number
    //Must contain at least 9 digits
    //Must contain no more than 12 digits

    public void assertEmptyAccountNoHelperTxt() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Enter a valid bank account number", accountNumberHelperTxt.getText());
    }

    public void assertAccountNoHelperTxtMinimumValue() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain at least 9 digits", accountNumberHelperTxt.getText());
    }

    public void assertAccountNoHelperTxtMaximumValue() {
        Assert.assertTrue(accountNumberHelperTxt.isDisplayed());
        Assert.assertEquals("Must contain no more than 12 digits", accountNumberHelperTxt.getText());
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[1]/h2")
    WebElement finishedHeadingThirdPopup;

    public void assertFinishedHeading3rdPopup() {
        Assert.assertTrue(finishedHeadingThirdPopup.isDisplayed());
        Assert.assertEquals("Finished", finishedHeadingThirdPopup.getText());
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/p")  //You're all set! + \n + \n + We're excited to have you aboard the Real World App!
    WebElement passusTxtThirdPopup;

    public void assertPassusTxt3rdPopup() {
        Assert.assertTrue(passusTxtThirdPopup.isDisplayed());
       // Assert.assertEquals("You're all set! + \n + \n + We're excited to have you aboard the Real World App!", passusTxtThirdPopup.getText());
     //todo check with team
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/h1/a")
    WebElement realWorldAppTitleLinkLogo;

    public void assertRWALink() {
        Assert.assertTrue(realWorldAppTitleLinkLogo.isDisplayed());
        Assert.assertTrue(realWorldAppTitleLinkLogo.isEnabled());
    }

    public void clickRWALogoLink() {
        realWorldAppTitleLinkLogo.click();
    }

    public void realWorldAppURLWhenClickedUpon() {
        realWorldAppTitleLinkLogo.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.qacademy.rs/");
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[2]/div/span")
    WebElement tabIndicator;

    public void assertTabIndicator() {
        Assert.assertTrue(tabIndicator.isDisplayed());  // todo ask the team how to assert tabIndicator with tabs (everyone, friends, mine)
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[2]/div/div/a[1]")
    WebElement everyoneLinkTab;  //URL:  https://app.qacademy.rs/

    public void assertEveryoneLinkTab() {
        String URLEveryone = "https://app.qacademy.rs/";
        Assert.assertEquals(driver.getCurrentUrl(), URLEveryone);
        Assert.assertTrue(everyoneLinkTab.isDisplayed());
        Assert.assertTrue(everyoneLinkTab.isEnabled());  //check if needed
     //   Assert.assertEquals("Everyone", everyoneLinkTab.getText());
        // todo check with team
        // BUG --> Link txt = Everyone, Actual = EVERYONE
    }

    public void clickEveryoneLinkTab() {
        everyoneLinkTab.click();
    }

    @FindBy (xpath = "//*[@id=\"root\"]/div/header/div[2]/div/div/a[2]")
    WebElement friendsTab;  //URL:  https://app.qacademy.rs/contacts

    public void assertFriendsTab() {
        Assert.assertTrue(friendsTab.isDisplayed());
        Assert.assertTrue(friendsTab.isEnabled()); //check if needed
        Assert.assertEquals("Friends", friendsTab.getText());
    }

    public void clickFriendsTab() {
        friendsTab.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[2]/div/div/a[3]")
    WebElement mineTab;  //URL:  https://app.qacademy.rs/personal

    public void assertMineTab() {
        Assert.assertTrue(mineTab.isDisplayed());
        Assert.assertTrue(mineTab.isEnabled()); //check if needed
        Assert.assertEquals("Mine", mineTab.getText());
    }

    public void clickMineTab() {
        mineTab.click();
    }

}
