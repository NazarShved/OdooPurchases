package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Olha extends BaseTest{


    @Test
    public void createVendorBillTest() throws InterruptedException {
        purchases.switchTab("Vendor Bills");
        $x(purchases.createButton).click();
        inputToAfield(byXpath("(//input[@class='o_input ui-autocomplete-input'])[1]"), "AB");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(byCss(".ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content")));

        purchases.pickADateCalendar(byXpath("//input[@name='date_invoice']"),"September", 9);
        purchases.pickADateCalendar(byXpath("//input[@name='date_due']"),"September", 15);

        $x("(//*[@class = 'o_field_x2many_list_row_add'])[1]/a").click();

        String itName = config.getProperty("itemName");
        inputToAfield(byXpath("(//input[@class='o_input ui-autocomplete-input'])[4]"), itName);
        $x(purchases.saveButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_loading")));
        String result = $x("//td[@class='o_data_cell']").getText();
        Assert.assertTrue(result.contains(itName));
    }
}
