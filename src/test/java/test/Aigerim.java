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


        Thread.sleep(4000);

        WebElement purchases = DriverSetup.getDriver().findElement(By.xpath("//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[9]/a/span"));
        WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingWhiteBox")));

        purchases.click();


        System.out.println(purchases.getText());

        Thread.sleep(2000);

       // Assert.assertTrue(purchases.isDisplayed());

//
//        WebElement vendorBills = DriverSetup.getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[9]/ul[2]/li[2]/a/span"));
//        Thread.sleep(3000);
//        vendorBills.click();

    }
}
