package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public LoginPage loginPage;
    public HeaderFooterLogosPage headerFooterLogosPage;
    public SignUpRegistrationPage signUpRegistrationPage;
    public HomePage homePage;

    public SidebarPage sidebarPage;
    public TransactionSelectContactPage transactionSelectContactPage;
    public TransactionPaymentPage transactionPaymentPage;
    public TransactionCompletePage transactionCompletePage;
    public BankAccountsPage bankAccountsPage;
    public NotificationsPage notificationsPage;
    public NewBankAccountPage newBankAccountPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        excelReader = new ExcelReader("src/test/java/DataTestRealWorldAppQAcademy.xlsx");
        loginPage = new LoginPage();
        headerFooterLogosPage = new HeaderFooterLogosPage();
        signUpRegistrationPage = new SignUpRegistrationPage();
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        transactionSelectContactPage = new TransactionSelectContactPage();
        transactionPaymentPage = new TransactionPaymentPage();
        transactionCompletePage = new TransactionCompletePage();
        bankAccountsPage = new BankAccountsPage();
        notificationsPage = new NotificationsPage();
        newBankAccountPage = new NewBankAccountPage();
    }

    public void scroll(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y);
        actions.perform();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}

