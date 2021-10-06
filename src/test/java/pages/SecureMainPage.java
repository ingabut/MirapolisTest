package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureMainPage extends AbstractPage{
    private By startPage = By.name("StudentStartPage");

    @FindBy(xpath = "//*[contains(@class, 'avatar-full-name')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'mira-user-info-logout')]")
    private WebElement logoutLink;

    public SecureMainPage(WebDriver driver) {
        super (driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isStartPage() {
        return isElementExists(startPage);
    }
    public void enterProfileMenu() {
        userMenu.click();
    }
    public void logout() {
        logoutLink.click();
    }

}
