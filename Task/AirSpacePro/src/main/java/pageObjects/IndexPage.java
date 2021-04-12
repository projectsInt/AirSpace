package pageObjects;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends CommonAPI {
    @FindBy(css = "#username")
    WebElement inputUser;
    @FindBy(css = "#password")
    WebElement inputPswd;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement ctrButton;
    // Just for the screenshot
    @FindBy(xpath = "//*[@type='submitt_lo'' ]")
    WebElement tryClick;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Login successfully  by using  correct credentials
     */
    //public void longInCredentials(){
    public SingInPage longInCredentials() {
        inputUser.sendKeys("tomsmith");
        inputPswd.sendKeys("SuperSecretPassword!");
        ctrButton.click();
        return new SingInPage();
    }

    /**
     * Login failed by using  incorrect credentials
     */
    //public void longInFailed(){
    public SingInPage longInFailedIncorrectUserId() {
        inputUser.sendKeys("tomsmiths786");
        inputPswd.sendKeys("SuperSecretPassword!");
        ctrButton.click();
        return new SingInPage();
    }

    /**
     * Login failed by using  incorrect credentials
     */
    //public void longInFailed(){
    public SingInPage longInFailedIncorrectpswd() {
        inputUser.sendKeys("tomsmith");
        inputPswd.sendKeys("SuperSecretPassword!786");
        ctrButton.click();
        return new SingInPage();
    }

    /**
     * This method is for the take screenshot
     */
    public SingInPage IncorrectData() {
        tryClick.click();
        return new SingInPage();
    }
}
