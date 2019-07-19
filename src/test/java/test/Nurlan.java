package test;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Nurlan extends BaseTest {

    @Test(priority = 1)
    public void checkSearchByPO()throws InterruptedException{

    purchases.search(config.getProperty("PONumber"));

    String actualPO = $x("(//td[@class='o_data_cell o_required_modifier'])[1]").getText();

    String expectedPO = config.getProperty("PONumber");

    Assert.assertEquals(actualPO,expectedPO, "No such PO number in the system");
    }


    @Test(priority = 2)

    public void checkSearchByWrongPO(){

        purchases.search(config.getProperty("note"));

        String text = (String)((JavascriptExecutor)getWebDriver()).executeScript("return document.getElementsByClassName(\"oe_view_nocontent\")[0].textContent");

        boolean expectedResult = text.contains("quotation is converted into a purchase order.");

        Assert.assertTrue(expectedResult, "Text Changed");


    }
}
