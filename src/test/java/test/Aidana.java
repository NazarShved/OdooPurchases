package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

public class Aidana extends BaseTest {

    //Test cases #156
    //Checks if the items are sorted by their status from "Available" to "Waiting Availability" (or vice versa)

    @Test(groups = {"smokeTest"})
    public void sortIncomingProductsByStatus() throws InterruptedException {
        purchases.switchTab("Incoming Products");
        purchases.switchToSortTab("Status");
        Thread.sleep(1000);
        List<WebElement> statusValues = $$(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        //System.out.println(statusValues.size());
        int count = 0;
        for (int i = 1; i < statusValues.size(); i ++) {
            if(!statusValues.get(i).getText().equals(statusValues.get(i-1).getText())){
                count++;
            }

        }
        Assert.assertTrue(count == 1);
    }


    //Test 162
    //Checks if ALL statusValues are displayed

    @Test (groups = {"smokeTest"})
    public void checkTheStatusOfItem() {
        purchases.switchTab("Incoming Products");
        List<WebElement> statusValues = $$(byXpath("//td[@class='o_data_cell o_readonly_modifier']"));
        int totalNumOfStatusValues = statusValues.size();
        //System.out.println("The total number of status values: " + totalNumOfStatusValues);
        int counter =0;
        for (WebElement statusValue : statusValues) {
            String statusText=statusValue.getText();
            counter++;
            Assert.assertTrue((statusText.equals("Available")||statusText.equals("Waiting Availability")) && (!statusText.isEmpty()), "The status of an item is not displayed.");
        }
        //System.out.println("The number of status values found by counter: " + counter);
        Assert.assertEquals(totalNumOfStatusValues, counter, "The total number of status values doesn't match with counter.");


    }
}
