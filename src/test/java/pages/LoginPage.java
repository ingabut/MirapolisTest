package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(@name, 'user')]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[contains(@name, 'password')]")
    private WebElement passwordField;

    //@FindBy(css = ".mira-default-tests.login-page-link")
    @FindBy(css = ".mira-default-login-page-link")
    private WebElement forgotPasswordLink;

    private By loginForm = By.id("login_form_panel");

    @FindBy(id = "button_submit_login_form")
    private WebElement loginButton;

    //@FindBy(id = "login_form_panel")
    //private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }
    public SecureMainPage clickLoginButton() {
        loginButton.click();
        return new SecureMainPage(getDriver());
    }
    public void alertClickToAccept() {
        try {
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // do nothing
        }
    }

    public PasswordRecoverPage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new PasswordRecoverPage(getDriver());
    }
    public boolean isLoginFormExists () {
        return isElementExists(loginForm);
    }

}
