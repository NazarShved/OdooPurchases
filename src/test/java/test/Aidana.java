package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class Aidana extends BaseTest {

    //Test cases #156
    //Checks if the items are sorted by their price

    @Ignore
    @Test
    public void sortIncomingProductsByStatus() throws InterruptedException {
        purchases.switchTab("Incoming Products");
        purchases.switchToSortTab("Status");
        Thread.sleep(1000);
        List<WebElement> statusValues = $$(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        System.out.println(statusValues.size());


        for (WebElement statusValue : statusValues) {

            //System.out.println(statusValue.getText());


        }
    }

    //Test 162
    //Checks if the status of item is displayed
    @Test
    public void checkTheStatusOfItem() {
        purchases.switchTab("Incoming Products");
        List<WebElement> statusValues = $$(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        int totalNumOfStatusValues = statusValues.size();
        int counter =0;
        for (WebElement statusValue : statusValues) {
            statusValue.getText();
            counter++;
            Assert.assertEquals(totalNumOfStatusValues, counter, "The total number of status values doesn't match with counter.");

        //

        }



    }
}
