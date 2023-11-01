package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    //After login, sidebar is active and visible

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div[1]/button/span[1]/svg")
    WebElement burgerBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/svg")
    WebElement imgHolder;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/h6[1]")
    WebElement userFullNameDisplayTxt;  //First + Last name

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/h6[2]")
    WebElement userNameDisplayTxt; //@ + username

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/h6[1]")
    WebElement userBalanceDisplayAmount; //$0.00

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/h6[2]")
    WebElement accountBalanceDisplayTxt; //Account Balance

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[1]/div[2]/span")
    WebElement homeBtn; // Home

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[2]/div[2]/span")
    WebElement myAccountBtn; //My Account

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[3]/div[2]/span")
    WebElement bankAccountsBtn; //Bank Accounts

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[3]/ul/div/a[4]/div[2]/span")
    WebElement notificationsBtn; //Notifications

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[5]/ul/div/div/div[2]/span")
    WebElement logoutBtn; //Logout
}
