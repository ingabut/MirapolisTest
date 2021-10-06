package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PasswordRecoverPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@name, 'loginOrEmail')]")
    private WebElement loginOrEmailField;

    @FindBy(css = ".mira-page-forgot-password-button")
    private WebElement sendButton;

    private By alertNotFound = By.className("alert");
    private By success = By.className("success");

    @FindBy(css = ".mira-page-forgot-password-link")
    private WebElement forgotPasswordLink;

    public PasswordRecoverPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void setLogin(String login) {
        loginOrEmailField.sendKeys(login);
    }
    public void clickSendButton() {
        sendButton.click();
    }
    public boolean isAlertExists() {
        return isElementExists(alertNotFound);
    }
    public boolean isSuccessExists() {
        return isElementExists(success);
    }
    public LoginPage returnToLoginPage() {
        forgotPasswordLink.click();
        return new LoginPage(getDriver());
    }

}
