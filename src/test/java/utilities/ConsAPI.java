package utilities;

import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

import java.util.List;

public abstract class ConsAPI {
    public abstract WebDriver getWebDriver();
    public static WebDriverWait wait;
    public static Config config;
    public static Logger log;

    public ConsAPI(){
        config = new Config("config.properties");
        wait = new WebDriverWait(getWebDriver(), 7);
        log = LogManager.getLogger(ConsAPI.class.getName());
    }



    //Loggs in when on ligin page
    public void login(){
        $("#login").sendKeys(config.getProperty("user1Login"));
        $("#password").sendKeys(config.getProperty("user1Pswd"));
        $(".btn.btn-primary").click();
    }

    //opens an inputed website
    public void open(String url){
        getWebDriver().get(url);
        log.debug("fff");

    }

    //Navigates to our project Website
    public void visit(){
        open(config.getProperty("url"));
    }

    //same as previous only for Xpath
    public  By byXpath(String xPath){
        return By.xpath(xPath);
    }

    //Takes By and returns a web element $(By.id("q"));
    public  WebElement $x(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Takes a String Xpath and returns a WebElement found by that Xpath $x("//*[@class = 'a']").click();
    public  WebElement $x(String xPath){
        return $(By.xpath(xPath));
    }

    //Takes string css selector returns By.cssSelector(Css)
    public  By byCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    //       // public static By by(String cssSelector){
//            return byCss(cssSelector);
//        }
//
    //Takes By and returns a web element $(By.id("q"));
    public  WebElement $(By by){
        return assertThat(ExpectedConditions.elementToBeClickable(by));
    }

    //Takes a String css selector and returns a WebElement $("cssSelector").click();
    public  WebElement $(String cssSelector){
        return $(By.cssSelector(cssSelector));
    }

    //Returns a list of elements found by the inputed By
    public  List<WebElement> $$(By by){
        return getWebDriver().findElements(by);
    }

    //Returns a list of elements by css selector inputed as a string
    public List<WebElement> $$(String cssSelector){
        return $$(By.cssSelector(cssSelector));
    }

    public WebElement $get(By listLocator, int index){
        return assertThat(Conditions.listSizeIsAtLeast(listLocator, index + 1)).get(index);

    }


    // can Use it instead of assert but you have to give parametr ExpectedConditions.(find the mathching condition);
    public  <V> V assertThat(Function<? super WebDriver, V> condition){
        return wait.until(condition);
    }

    public void inputToAfield(By by, String text) throws InterruptedException {
        $(by).sendKeys(text);
        $(by).sendKeys(Keys.ENTER);
    }

    public void inputToAfield(By by, String text, By checkForVis){
        $(by).sendKeys(text);
        wait.until(ExpectedConditions.elementToBeClickable(checkForVis));
        $(by).sendKeys(Keys.ENTER);
}

}
