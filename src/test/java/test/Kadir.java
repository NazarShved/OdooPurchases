package test;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Conditions;

public class Kadir extends BaseTest {

    @Test(groups = {"smokeTest"})
    public void addNewVendorTest() throws InterruptedException {
        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the Vendor name in the nameBox
        inputToAfield(byCss(".o_field_char.o_field_widget.o_input.o_required_modifier"), "Cybertek");
        //locating the Vendor Address,
        inputToAfield(byXpath("(//input[@class='o_field_char o_field_widget o_input o_address_street'])[1]"), config.getProperty("VendorAddress"));
        //locating the City
        inputToAfield(byXpath("(//input[@class='o_field_char o_field_widget o_input o_address_city'])[1]"), config.getProperty("City"));
        //locating the State

        inputToAfield(byXpath( "(//input[@class='o_input ui-autocomplete-input'])[2]"), "ILLINOIS");
        //locating the ZIP Code
        inputToAfield(byXpath("(//input[@class='o_field_char o_field_widget o_input o_address_zip'])[1]"), config.getProperty("Zip") );
        //locating the Country

        inputToAfield(byXpath( "(//input[@class='o_input ui-autocomplete-input'])[3]"), "USA");
        //locating the vendor TIN

        inputToAfield(byXpath("(//input[@class='o_field_char o_field_widget o_input'])[1]"), config.getProperty("TIN"));
        //locating the TAG

        inputToAfield(byXpath( "(//input[@class='o_input ui-autocomplete-input'])[4]"), "Developer");

        //locating the Vendor Phone

        inputToAfield(byXpath("(//input[@class='o_field_phone o_field_widget o_input'])[1]"), config.getProperty("VendorPhone"));
        //locating the Vendor e-mail

        inputToAfield(byXpath("(//input[@class='o_field_email o_field_widget o_input'])[1]"),config.getProperty("VendorEmail") );
        //locating the Vendor website

       // $x("(//input[@class='o_field_url o_field_widget o_input'])[1]").sendKeys(config.getProperty("VendorWebsite"));
        inputToAfield(byXpath("(//input[@class='o_field_url o_field_widget o_input'])[1]"), config.getProperty("VendorWebsite") );
        //locating the Tittle

        inputToAfield(byXpath("(//input[@class='o_input ui-autocomplete-input'])[5]"), "IT");

        //Leave a note
        $x("(//a[@data-toggle='tab'])[2]").click();
        inputToAfield(byCss(".o_field_text.o_field_widget.o_input"),config.getProperty("note") );

        // selecting save & close button
        $x(purchases.saveButton).click();
        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".o_thread_message_content"), "Contact created"));

    }
}

