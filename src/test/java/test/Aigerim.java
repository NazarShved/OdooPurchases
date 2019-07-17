package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;


public class Aigerim extends BaseTest {


    @Test
    public void VendorBills() throws InterruptedException {

        //Actions actions = new Actions(DriverSetup.getDriver());
       
        purchases.switchTab("Vendors");

        //System.out.println(purchases.getText());
      // Assert.assertTrue(purchases.isDisplayed());

//
//        WebElement vendorBills = DriverSetup.getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[9]/ul[2]/li[2]/a/span"));
//        Thread.sleep(3000);
//        vendorBills.click();

    }
}
