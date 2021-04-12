package pageObjects;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage extends CommonAPI {
    // I need to create only one method just to logOut
    @FindBy(xpath = "//i[@class='icon-2x icon-signout']")
    WebElement ctrLogout;

    public SingInPage() {
        PageFactory.initElements(driver, this);
    }

    //public void logOut(){
    public LogOutPage logOut() {
        ctrLogout.click();
        return new LogOutPage(); // Landing class is going to use 2 places
        // inside the Page class and Test class to store before run
    }
}
