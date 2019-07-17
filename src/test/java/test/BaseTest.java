package test;

import com.pages.PurchasesPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConciseAPI;
import utilities.ConfigReader;
import utilities.DriverSetup;

import java.sql.Driver;

public class BaseTest extends ConciseAPI {

    @BeforeMethod
    public void setUp(){
        PurchasesPage purchase = new PurchasesPage();
        purchase.goToPurchases();
    }

    @AfterMethod
    public void tearDown(){ DriverSetup.quitDriver();
    }


    @Override
    public WebDriver getWebDriver() {
        return DriverSetup.getDriver();
    }
}
