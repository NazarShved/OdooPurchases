package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Conditions {
    public static ExpectedCondition<Boolean> listNthElementHasText(
            final By listLocator, final int nthElement, final String expectedText){
        return new ExpectedCondition<Boolean>() {
            private String nthElementText = "";

            public Boolean apply(WebDriver input) {
                try {
                    nthElementText = input.findElements(listLocator).get(nthElement).getText();
                    return nthElementText.contains(expectedText);
                } catch (IndexOutOfBoundsException exception){
                    return false;
                }

            }

            @Override
            public String toString() {
                return String.format("%dth element \nof %s list \nto have text: %s\n while actual text is: %s\n"
                        , nthElement + 1, listLocator, expectedText, nthElementText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> listSizeIsAtLeast(final By listLocator, final int minimumSize){
        return new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver input) {
                List<WebElement> list = input.findElements(listLocator);
                return list.size() >= minimumSize ? list : null;
            }
        };
    }


}
