package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Nurlan extends BaseTest {

    @Test
    public void searchFuntion() {

        $x("//span[@class='o_searchview_more fa fa-search-plus']").click();
        boolean actualFilter = $x("//span[@class='fa fa-filter']").isDisplayed();
        boolean expectedFilter = true;
        Assert.assertEquals(actualFilter, expectedFilter, "Filter in Advanced Search is NOT located!");

        boolean groupBy = $x("//span[@class='fa fa-bars']").isDisplayed();
        Assert.assertEquals(groupBy, expectedFilter, "Group By in Advanced Search is NOT located");

        boolean favorites = $x("//span[@class='fa fa-star']").isDisplayed();
        Assert.assertEquals(favorites, expectedFilter, "Favorites in Advanced Search is NOT located");


    }

   // @Test(dependsOnMethods = "searchFuntion")
    public void checkFilterList() {
        searchFuntion();
        boolean filter = filterSearch();
        boolean expectedFilter = true;
        Assert.assertEquals(filter, expectedFilter, "Filter List is wrong");

    }

    public boolean filterSearch() {


        $x("(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]").click();

        List<WebElement> filters = $s(By.xpath("//ul[@class='dropdown-menu o_filters_menu']//a"));

        System.out.println(filters);
        System.out.println(filters.size());
        if ((filters.size() == 11) && (filters.contains("Quotations") && filters.contains("Purchase Orders") &&
                filters.contains("To Approve") && filters.contains("Waiting Bills") &&
                filters.contains("Bills Received") && filters.contains("My Activities") &&
                filters.contains("Unread Messages") && filters.contains("Late Activities") &&
                filters.contains("Today Activities") && filters.contains("Future Activities")
                && filters.contains("Add Custom Filter"))){
            System.out.println(filters.size());
            return true;
        }
        return false;

    }

}
