package test;

import com.pages.PurchasesPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConsAPI;
import utilities.DriverSetup;

public class BaseTest extends ConsAPI {

    public  PurchasesPage purchases = new PurchasesPage();

    @BeforeMethod
    public void setUp() {
        PurchasesPage purchase = new PurchasesPage();
        purchase.goToPurchases();
    }

    @AfterMethod
    public void tearDown() {
        DriverSetup.quitDriver();
    }


    @Override
    public WebDriver getWebDriver() {
       return DriverSetup.getDriver();
    }
}