package tests.login;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ValidLoginTests extends BaseTests {

    @Test(description = "Test if tests.login was successful")
    public void testSuccessfulLogin(){
        loginPage.setUsername("fominaelena");
        loginPage.setPassword("z0K6CTQR");
        secureMainPage = loginPage.clickLoginButton();
        System.out.println(secureMainPage.getDriver());
        assertTrue(secureMainPage.isStartPage(),
                "Main page didn't opened");
    }


}