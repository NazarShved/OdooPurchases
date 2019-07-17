package test;

import com.github.javafaker.Faker;
import com.pages.PurchasesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.Conditions;

public class Nazar extends BaseTest{

@Test
//#116 , #126
    public void searchFunctionalityTest(){
    $$(".o_data_row").size();
    purchases.switchTab("Products");
    String testInput = config.getProperty("testSearchInput");
    purchases.search(testInput);
    //check if all list elements(search results) contain the searchable word
    assertThat(Conditions.textToBePresentInElementsLocatedIgnoreCase(byCss(".o_kanban_record_title"), testInput));
    //verify that a closable block containing a search value is present
    assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byXpath("(//*[@class = 'o_facet_values']/span)[2]"), testInput));
}


}
