package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Aidana extends BaseTest {

    //Test cases #156,162

    @Test
    public void sortIncomingProductsByStatus() throws InterruptedException {
        purchases.switchTab("Incoming Products");
        purchases.switchToSortTab("Status");
        Thread.sleep(1000);
        List<WebElement> statusValues = $$(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        System.out.println(statusValues.size());
        for (WebElement statusValue:statusValues) {

            //System.out.println(statusValue.getText());
        }
    }
}
