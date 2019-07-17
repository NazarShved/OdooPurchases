package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private DriverSetup(){

    }

    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConsAPI.config.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        return driver;
    }



    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }


}
