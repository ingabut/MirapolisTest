package tests.login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class InvalidLoginTests extends BaseTests {
    @DataProvider
    private Object[][] invalidCredentials(){
        return new Object[][] {
                {"fominaelena", ""},//empty password
                {"", "z0K6CTQR"    },//empty tests.login
                {"fominaelena", "z0K6CTQ"},//wrong password
                {"",""}                    // empty
        };
    }

    @Test(description = "Test if tests.login was not successful", dataProvider = "invalidCredentials")
    public void testNotSuccessfulLogin(String login, String password){
        loginPage.setUsername(login);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        loginPage.alertClickToAccept();

        assertTrue(loginPage.isLoginFormExists(),
                "Login page didn't opened");
    }
}
