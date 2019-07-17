package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Conditions;
import utilities.ConfigReader;

import java.util.List;

public class PurchasesPage extends BasePage {
    public By searchField = By.cssSelector(".o_searchview_input");

    //Clicks on the inputed tab from the menu to the right CaseSensitive
    public void switchTab(String tab){
        List<WebElement> sideTabs =  $$("div[data-menu-parent='504'] .oe_menu_text");
        for (WebElement el: sideTabs){
            if(el.getText().equals(tab)){
                el.click();
                wait.until(ExpectedConditions.textToBePresentInElementLocated(byXpath("(//li[@class = 'active'])[3]"), tab));
                break;
            }
        }
    }

    //Runs a search for the inputed word
    public void search(String input){
        $(searchField).clear();
        $(searchField).sendKeys(input, Keys.ENTER);
        wait.until(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".o_kanban_record_title"), input));
    }

    //opens website logs in, and navigates to purchases module
    public  void goToPurchases(){
        visit();
        login();
        $get(By.className("oe_menu_text"),8).click();
    }
}
