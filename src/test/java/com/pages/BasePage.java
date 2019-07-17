package com.pages;

import org.openqa.selenium.WebDriver;
import utilities.ConciseAPI;
import utilities.DriverSetup;

public class BasePage extends ConciseAPI {
    @Override
    public WebDriver getWebDriver() {
        return DriverSetup.getDriver();
    }


}
