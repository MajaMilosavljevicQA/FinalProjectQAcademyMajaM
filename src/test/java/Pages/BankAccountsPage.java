package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankAccountsPage extends BaseTest {
    public BankAccountsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/div/div[1]/h2")
    WebElement bankAccountsHeader;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div/ul/li/div/div[1]/p")  //as12#
    WebElement userBankAccount;  //todo assert bank account equals one on registration form

    @FindBy(linkText = "Create")  //same again, on this pg for Create and Delete
    WebElement createBtn;
}
