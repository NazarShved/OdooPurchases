package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Conditions;

import java.util.List;

public class PurchasesPage extends BasePage {
    public By searchField = By.cssSelector(".o_searchview_input");
    public By createButton = byXpath("//button[@class='btn btn-primary btn-sm o_list_button_add']");
    public By saveButton = byCss(".btn.btn-primary.btn-sm.o_form_button_save");
    public By dropDownSuggestionBlock = byCss(".ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content");

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));
        $get(By.className("oe_menu_text"),8).click();
    }

    public void pickADateCalendar(By calendarLocator, String month, int date){
        $(calendarLocator).click();
        wait.until(ExpectedConditions.visibilityOf($get(byCss(".table-condensed"), 2)));
        while (true){
            if($(".picker-switch").getText().toLowerCase().contains(month.toLowerCase())){
                break;
            }
            else $get(byCss(".fa.fa-chevron-right"), 3).click();
        }
        $get(byXpath("//*[@data-action = 'selectDay']"), date-1).click();
    }
}
