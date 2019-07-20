package test;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Conditions;
import org.apache.logging.log4j.*;



public class Nazar extends BaseTest{

    @Test(groups = {"smokeTest"})
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

    @Test(groups = {"smokeTest"})
    public void dropDownTest(){
        //#126 Display/Hide advanced search options

        WebElement advencedSearchOptions = getWebDriver().findElement(purchases.searchOptinsTab);
        if (!advencedSearchOptions.isDisplayed()) purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.visibilityOf(advencedSearchOptions));
        purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.invisibilityOf(advencedSearchOptions));

    }

    @Test(groups = {"smokeTest"})
    public void kanbanListTest() {
        //Display results in Canban or list view

            purchases.resultsAsCanban();
            Assert.assertTrue($$(purchases.resultsInList).size()==0);
            purchases.resultsAsList();
            Assert.assertTrue($$(purchases.resultsInCanban).size()==0);
    }

    @Test
    public void logtest(){
        log.error("lal");
    }
}
