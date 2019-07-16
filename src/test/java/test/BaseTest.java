package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class BaseTest extends Driver{

    @BeforeMethod
    public void setUp(){
        Driver.goToPurchases();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }




}
