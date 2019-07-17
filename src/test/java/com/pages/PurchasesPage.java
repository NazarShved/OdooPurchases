package com.pages;

import utilities.ConfigReader;

public class PurchasesPage extends BasePage {

    //Navigates to our project Website
    public  void goToPurchases(){
        visit();
        login();
        $x("(//span[@class = 'oe_menu_text'])[9]").click();
    }
}
