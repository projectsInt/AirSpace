package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    FileInputStream fis;
    public static Properties prop;
    public static WebDriver driver;

    public CommonAPI() {
        try {
            fis = new FileInputStream("/Users/abc/Desktop/Task/Generic/src/main/java/config/config.properties");
            prop = new Properties();
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/Task/Generic/src/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/abc/IdeaProject/SanctionScreening/Generic/src/driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/login");

    }

    public void failedTest(String testMethodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("/Users/abc/Desktop/Task/Generic/src/main/" +
                    "java/ScreenShotsFailedTests/" + testMethodName + "_" + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






