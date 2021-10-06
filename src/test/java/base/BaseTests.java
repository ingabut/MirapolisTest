package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.SecureMainPage;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected SecureMainPage secureMainPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
    }
    @BeforeMethod
    public void goHome() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        loginPage = new LoginPage(driver);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }
    @AfterMethod
    public void logout() {
        if (secureMainPage!= null) {
            secureMainPage.enterProfileMenu();
            secureMainPage.logout();
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("disable-infobars");
        return options;
    }



}
