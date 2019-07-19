package test;

import com.google.common.base.Function;
import com.pages.PurchasesPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConsAPI;
import utilities.DriverSetup;

import java.sql.Driver;

public class BaseTest extends ConsAPI {

    public PurchasesPage purchases;

    @BeforeMethod
    public void setUp(){
        purchases = new PurchasesPage();
        purchases.goToPurchases();
    }

    @AfterMethod
    public void tearDown(){
        DriverSetup.quitDriver();
    }


    @Override
    public WebDriver getWebDriver() {
        return DriverSetup.getDriver();
    }
}
