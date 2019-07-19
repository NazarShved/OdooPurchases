package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Conditions;

import java.util.List;

public class PurchasesPage extends BasePage {
    public By searchField = byCss(".o_searchview_input");
    public By searchOptinsTab = byCss(".btn-group.o_search_options");
    public By resultsInCanban = byCss(".oe_kanban_global_click.o_kanban_record");
    public By resultsInList = byCss(".o_data_row");

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
        $(searchField).sendKeys(input);
        $(searchField).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));

            if ($$(resultsInCanban).size() > 0)
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsInCanban));

            else if($$(resultsInList).size() > 0)
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsInList));

    }

    //opens website logs in, and navigates to purchases module
    public  void goToPurchases(){
        visit();
        login();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));
        $get(By.className("oe_menu_text"),8).click();

        wait.until(Conditions.listSizeIsAtLeast(byCss(".o_data_row"), 50));
    }

    public void showHideSearchFilters(){
        $("[title = 'Advanced Search...']").click();
    }
    public void resultsAsCanban(){
        $("[aria-label='kanban']").click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));
    }
    public void resultsAsList(){
        $("[aria-label='list']").click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));
    }
}
