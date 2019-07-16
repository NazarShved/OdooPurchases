package utilities;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Driver extends DriverSetup {

        private Driver(){

        }

        //Loggs in when on ligin page
        public static void login(){
            Driver.$("#login").sendKeys(ConfigReader.getProperty("user1Login"));
            Driver.$("#password").sendKeys(ConfigReader.getProperty("user1Pswd"));
            Driver.$(".btn.btn-primary").click();
        }

        //opens an inputed website
        public static void open(String url){
            getDriver().get(url);
        }

        //Navigates to our project Website
        public static void visit(){
            open(ConfigReader.getProperty("url"));
        }

        //opens website logsin, and navigates to purchases module
        public static void goToPurchases(){
            visit();
            login();
            $x("(//span[@class = 'oe_menu_text'])[9]").click();
        }



        //same as previous only for Xpath
        public static By byXpath(String xPath){
            return By.xpath(xPath);
        }

        //Takes By and returns a web element $(By.id("q"));
        public static WebElement $x(By by){
            return assertThat(ExpectedConditions.visibilityOfElementLocated(by));
        }

        //Takes a String Xpath and returns a WebElement found by that Xpath $x("//*[@class = 'a']").click();
        public static WebElement $x(String xPath){
            return $(By.xpath(xPath));
        }

        //Takes string css selector returns By.cssSelector(Css)
        public static By byCss(String cssSelector){
            return By.cssSelector(cssSelector);
        }

//       // public static By by(String cssSelector){
//            return byCss(cssSelector);
//        }

        //Takes By and returns a web element $(By.id("q"));
        public static WebElement $(By by){
            return assertThat(ExpectedConditions.visibilityOfElementLocated(by));
        }

        //Takes a String css selector and returns a WebElement $("cssSelector").click();
        public static WebElement $(String cssSelector){
            return $(By.cssSelector(cssSelector));
        }

        //Makes a WebDriverWait return a WebElement dont use it
        private static  <V> V assertThat(Function<? super WebDriver, V> condition){
            return (new WebDriverWait(getDriver(), 5)).until(condition);
        }
// What the heck
}
