package test;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Conditions;

public class Kadir extends BaseTest {

    @Test
            public void addNewVendorTest() throws InterruptedException {
        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the Vendor name in the nameBox
        $(".o_field_char.o_field_widget.o_input.o_required_modifier").sendKeys("Cybertek");
        //locating the Vendor Address
        $x("(//input[@class='o_field_char o_field_widget o_input o_address_street'])[1]").sendKeys(config.getProperty("VendorAddress"));
        //locating the City
        $x("(//input[@class='o_field_char o_field_widget o_input o_address_city'])[1]").sendKeys(config.getProperty("City"));

        //locating the State

        $x( "(//input[@class='o_input ui-autocomplete-input'])[2]").sendKeys("ILLINIOUS");

        //locating the ZIP Code
        $x("(//input[@class='o_field_char o_field_widget o_input o_address_zip'])[1]").sendKeys(config.getProperty("Zip"));

        //locating the Country

        $x( "(//input[@class='o_input ui-autocomplete-input'])[3]").sendKeys("USA");

        //locating the vendor TIN

        $x("(//input[@class='o_field_char o_field_widget o_input'])[1]").sendKeys(config.getProperty("TIN"));

        //locating the TAG

        $x( "(//input[@class='o_input ui-autocomplete-input'])[4]").sendKeys("Developer");


        //locating the Vendor Phone
        $x("(//input[@class='o_field_phone o_field_widget o_input'])[1]").sendKeys(config.getProperty("VendorPhone"));

        //locating the Vendor e-mail
        $x("(//input[@class='o_field_email o_field_widget o_input'])[1]").sendKeys(config.getProperty("VendorEmail"));

        //locating the Vendor website

        $x("(//input[@class='o_field_url o_field_widget o_input'])[1]").sendKeys(config.getProperty("VendorWebsite"));

        //locating the Tittle

        $x( "(//input[@class='o_input ui-autocomplete-input'])[5]").sendKeys("IT");

        $x("//textarea[@id='o_field_input_501']").sendKeys(config.getProperty("note"));
        // selecting save & close button
        $x("(//button[@class='btn btn-sm btn-primary'])[1]").click();
















    }
}

