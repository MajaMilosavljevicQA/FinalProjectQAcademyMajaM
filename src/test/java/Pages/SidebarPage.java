package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    //After login, sidebar is active and visible

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/button")
    WebElement burgerBtn;

    public void assertBurgerBtn() {
        Assert.assertTrue(burgerBtn.isDisplayed());
       // Assert.assertTrue(burgerBtn.isEnabled());
    }

    public void clickBurgerBtn() {
        burgerBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/svg")
    WebElement imgHolder;

    public void assertImgHolder() {
        Assert.assertTrue(imgHolder.isDisplayed());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/h6[1]")
    WebElement userFullNameDisplayTxt;  //First + Last name

    public void assertFullNameTxt() {
        Assert.assertTrue(userFullNameDisplayTxt.isDisplayed());
      //  Assert.assertEquals(); // todo assert input from Excel --> first & last name = actual/expected result
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/h6[2]")
    WebElement userNameDisplayTxt; //@ + username

    public void assertUserNameTxt() {
        Assert.assertTrue(userNameDisplayTxt.isDisplayed());
        // todo assert username equals actual/expected --> "@" + input from Excel
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/h6[1]")
    WebElement userBalanceDisplayAmount; //$0.00

    public void assertUserBalanceAmount() {
        Assert.assertTrue(userBalanceDisplayAmount.isDisplayed());
        // todo find out how to assert amount when changing
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/h6[2]")
    WebElement accountBalanceDisplayTxt; //Account Balance

    public void assertAccountBalanceTxt() {
        Assert.assertTrue(accountBalanceDisplayTxt.isDisplayed());
        Assert.assertEquals("Account Balance",accountBalanceDisplayTxt.getText());
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[1]/div[2]/span")
    WebElement homeLink; // Home

    public void assertHomeLink() {
        Assert.assertTrue(homeLink.isDisplayed());
        Assert.assertTrue(homeLink.isEnabled());
        Assert.assertEquals("Home", homeLink.getText());
    }

    public void clickHomeLink() {
        homeLink.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[2]/div[2]/span")
    WebElement myAccountLink; //My Account

    public void assertMyAccountLink() {
        Assert.assertTrue(myAccountLink.isDisplayed());
        Assert.assertTrue(myAccountLink.isEnabled());
        Assert.assertEquals("My Account", myAccountLink.getText());
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[3]/div[2]/span")
    WebElement bankAccountsLink; //Bank Accounts

    public void assertBankAccountLink() {
        Assert.assertTrue(bankAccountsLink.isDisplayed());
        Assert.assertTrue(bankAccountsLink.isEnabled());
        Assert.assertEquals("Bank Accounts", bankAccountsLink.getText());
    }

    public void clickBankAccountLink() {
        bankAccountsLink.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[4]/div[2]/span")
    WebElement notificationsLink; //Notifications

    public void assertNotificationLink() {
        Assert.assertTrue(notificationsLink.isDisplayed());
        Assert.assertTrue(notificationsLink.isEnabled());
        Assert.assertEquals("Notifications", notificationsLink.getText());
    }

    public void clickNotificartionLink() {
        notificationsLink.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[5]/ul/div/div")
    WebElement logoutLink; //Logout

    public void assertLogoutLink() {
        Assert.assertTrue(logoutLink.isDisplayed());
        Assert.assertTrue(logoutLink.isEnabled());
        Assert.assertEquals("Logout", logoutLink.getText());
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

}
