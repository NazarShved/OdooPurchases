package com.pages;

import org.openqa.selenium.WebDriver;
import utilities.ConsAPI;
import utilities.DriverSetup;

public class BasePage extends ConsAPI {
    @Override
    public WebDriver getWebDriver() {
        return DriverSetup.getDriver();
    }


}
