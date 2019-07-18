package test;

import com.github.javafaker.Faker;
import com.pages.PurchasesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Conditions;

import java.util.List;

public class Nazar extends BaseTest{

    @Test
    public void searchFunctionalityTest(){
    //Input an acceptable word to the search field and press Enter #116

    purchases.switchTab("Products");
    String testInput = config.getProperty("testSearchInput");
    purchases.search(testInput);

    //check if all list elements(search results) contain the searchable word
    assertThat(Conditions.textToBePresentInElementsLocatedIgnoreCase(byCss(".o_kanban_record_title"), testInput));
    //verify that a closable block containing a search value is present
    assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byXpath("(//*[@class = 'o_facet_values']/span)[2]"), testInput));
}

    @Test
    public void dropDownTest(){

        //#126 As a manager I should be able to search the product by its name.
        WebElement advencedSearchOptions = getWebDriver().findElement(purchases.searchOptinsTab);
        if (!advencedSearchOptions.isDisplayed()) purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.visibilityOf(advencedSearchOptions));
        purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.invisibilityOf(advencedSearchOptions));

    }

    @Test
    public void kanbanListTest() {
            purchases.resultsAsCanban();
            Assert.assertTrue($$(purchases.resultsInList).size()==0);
            purchases.resultsAsList();
            Assert.assertTrue($$(purchases.resultsInCanban).size()==0);
    }
    
}
