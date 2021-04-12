package pageObjectsTests;

import base.CommonAPI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.LogOutPage;
import pageObjects.SingInPage;

public class SignInPageTest extends CommonAPI {
    IndexPage indexPage;
    SingInPage singInPage;
    LogOutPage logOutPage;

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void logOutTest() {
        indexPage = new IndexPage();
        //indexPage.longInCredentials();
        singInPage = indexPage.longInCredentials();
        //singInPage.logOut();
        logOutPage = singInPage.logOut();
    }
}