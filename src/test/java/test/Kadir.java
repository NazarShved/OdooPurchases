package test;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Conditions;

public class Kadir extends BaseTest {

    @Test
            public void addNewVendorTest() {
        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the Vendor name in the nameBox
        $(".o_field_char.o_field_widget.o_input.o_required_modifier").sendKeys("Cybertek");
        //locating the Vendor Address
        $x("//input[@id='o_field_input_495']").sendKeys(config.getProperty("VendorAd"));





    }
}

