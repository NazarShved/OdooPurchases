package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Conditions;
import utilities.DriverSetup;


public class Aigerim extends BaseTest {


    @Test
    public void VendorBills() throws InterruptedException {

        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the name in the nameBox
        $(".o_field_char.o_field_widget.o_input.o_required_modifier").sendKeys("Tester1");
        // locating create button on the buttom of the page
        $(".btn.btn-primary.btn-sm.o-kanban-button-new").click();
        // creating contactName
        String inp = config.getProperty("contactName");
        $x("//input[@id='o_field_input_495']").sendKeys(inp);
        // locating titleLink
        $get(byCss(".o_input.ui-autocomplete-input"), 14).click();
        // selecting IT title
        $get(byCss(".ui-menu-item"), 6).click();
        // typing phoneNumber
        $x("//input[@id='o_field_input_499']").sendKeys(config.getProperty("phoneNumber"));
        // making note for a new contact
        $x("//textarea[@id='o_field_input_501']").sendKeys(config.getProperty("note"));
        // selecting save & close button
        $x("(//button[@class='btn btn-sm btn-primary'])[1]").click();

        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".oe_kanban_details"),inp));

    }
}
