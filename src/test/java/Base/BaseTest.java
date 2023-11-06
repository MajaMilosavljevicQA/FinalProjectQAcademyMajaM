package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public LoginPage loginPage;
    public HeaderFooterLogos headerFooterLogos;
    public SignUpRegistrationPage signUpRegistrationPage;
    public HomePage homePage;

    public SidebarPage sidebarPage;
    public TransactionSelectContactPage transactionSelectContactPage;
    public TransactionPaymentPage transactionPaymentPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        headerFooterLogos = new HeaderFooterLogos();
        signUpRegistrationPage = new SignUpRegistrationPage();
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        transactionSelectContactPage = new TransactionSelectContactPage();
        transactionPaymentPage = new TransactionPaymentPage();
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

