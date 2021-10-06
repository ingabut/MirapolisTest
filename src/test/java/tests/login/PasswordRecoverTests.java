package tests.login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PasswordRecoverPage;

import static org.testng.Assert.assertTrue;

public class PasswordRecoverTests extends BaseTests {

    @DataProvider
    private Object[][] invalidLogins(){
        return new Object[][] {
                {"fominaelen"},             //incorrect tests.login
                {""},                        //empty tests.login
                {"fominaelena@company.ru"},  //incorrect email
                {"fominaelena@"}             //wrong email
        };
    }

    @Test(description = "Test forgot password successful")
    public void testForgotPasswordSuccess(){
        PasswordRecoverPage recoverPage = loginPage.clickForgotPasswordLink();
        recoverPage.setLogin("fominaelena");
        recoverPage.clickSendButton();
        assertTrue(recoverPage.isSuccessExists(),"Successful message isn't appeared");
    }
    @Test(description = "Test forgot password failed", dataProvider = "invalidLogins")
    public void testForgotPasswordFail(String login){
        PasswordRecoverPage recoverPage = loginPage.clickForgotPasswordLink();
        recoverPage.setLogin(login);
        recoverPage.clickSendButton();
        assertTrue(recoverPage.isAlertExists(),"Alert isn't appeared");
    }
}
