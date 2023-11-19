package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.secureAreaPage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        secureAreaPage secureAreaPage =  loginPage.clickLoginButton();
        secureAreaPage.getAletText();

        assertTrue(secureAreaPage.getAletText().contains("You logged into dropdown.a secure area!"), "Alert text is incorrect");
    }
}