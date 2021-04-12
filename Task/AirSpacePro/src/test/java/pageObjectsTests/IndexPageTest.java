package pageObjectsTests;

import base.CommonAPI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import pageObjects.SingInPage;

@Listeners(CustomLister.class)
public class IndexPageTest extends CommonAPI {
    IndexPage indexPage;
    SingInPage singInPage;

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @AfterMethod
    public void clearUp() {
        driver.close();
    }

    @Test
    public void longInCredentialsTest() {
        indexPage = new IndexPage();
        // indexPage.longInCredentials();
        singInPage = indexPage.longInCredentials();
    }

    @Test
    public void logInFailedIncorrectUserIdTest() {
        indexPage = new IndexPage();
        // indexPage.longInCredentials();
        singInPage = indexPage.longInFailedIncorrectUserId();
    }

    @Test
    public void logInFailedIncorrectPswdTest() {
        indexPage = new IndexPage();
        // indexPage.longInCredentials();
        singInPage = indexPage.longInFailedIncorrectpswd();
    }

    // User should able to see the screenshot had taken successfully
    @Test
    public void FailedTest() {
        indexPage = new IndexPage();
        //indexPage.testingWrongTest();
        singInPage = indexPage.IncorrectData();
    }
}
