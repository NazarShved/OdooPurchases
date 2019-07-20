package test;

import com.pages.PurchasesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConsAPI;
import utilities.DriverSetup;

public class BaseTest extends ConsAPI {

    public PurchasesPage purchases;

    @BeforeMethod(groups = {"smokeTest"})
    public void setUp(){
        purchases = new PurchasesPage();
        purchases.goToPurchases();
    }

    @AfterMethod(groups = {"smokeTest"})
    public void tearDown(){
        DriverSetup.quitDriver();
    }


    @Override
    public WebDriver getWebDriver() {
        return DriverSetup.getDriver();
    }
}
