package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    protected boolean isElementExists(By element) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
