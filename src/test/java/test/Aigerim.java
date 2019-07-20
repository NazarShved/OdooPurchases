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


    @Test(groups = {"smokeTest"})
    public void VendorBills() throws InterruptedException {
        //Create new Contact in New Vendor tab

        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the name in the nameBox
        $(".o_field_char.o_field_widget.o_input.o_required_modifier").sendKeys("Tester1");
        // locating create button on the buttom of the page
        $(".btn.btn-primary.btn-sm.o-kanban-button-new").click();
        // creating contactName
        String inp = config.getProperty("contactName");
        $x("(//input[@class='o_field_char o_field_widget o_input o_required_modifier'])[2]").sendKeys(inp);
        // locating titleLink
        $get(byCss(".o_input.ui-autocomplete-input"), 14).click();
        // selecting IT title
        $get(byCss(".ui-menu-item"), 6).click();
        // typing phoneNumber
        $x("(//input[@class='o_field_phone o_field_widget o_input'])[3]").sendKeys(config.getProperty("phoneNumber"));
        // making note for a new contact
        $x("(//textarea[@class='o_field_text o_field_widget o_input'])[2]").sendKeys(config.getProperty("note"));
        // selecting save & close button
        $x("(//button[@class='btn btn-sm btn-primary'])[1]").click();

        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".oe_kanban_details"),inp));

    }
}
