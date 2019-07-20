package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;


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

    public static ExpectedCondition<Boolean> textToBePresentInElementsLocatedIgnoreCase(final By listLocator, final String text){
        return new ExpectedCondition<Boolean>() {
            String missmathc = "";
            public Boolean apply(WebDriver input) {
                List<WebElement> list = input.findElements(listLocator);
                if(list.size() < 1) {
                    missmathc = "No elements found";
                    return false;
                }
                for(WebElement el : list){
                    if(el.getText().toLowerCase().contains(text.toLowerCase())) continue;
                    else{
                        missmathc = el.getText();
                        return false;
                    }
                }
                return true;
            }

            @Override
            public String toString() {
                return String.format("String\"" + text + "\" to be present in every element's text.\nActual result: \""+missmathc+"\"");
            }

        };
    }

    public static ExpectedCondition<Boolean> textToBePresentInElementLocatedIgnoreCase(final By elementLocator, final String text){
        return new ExpectedCondition<Boolean>() {
            String missmathc = "";
            public Boolean apply(WebDriver input) {
                WebElement check = input.findElement(elementLocator);
                if(check.getText().toLowerCase().contains(text.toLowerCase())) return true;
                else{
                    missmathc = check.getText();
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("String\"" + text + "\" to be present in element's text.\nActual text: \""+missmathc+"\"");
            }

        };
    }

    public static ExpectedCondition<Boolean> textToBePresentInInputFieldLocatedIgnoreCase(final String className, final int index, final String text){
        return new ExpectedCondition<Boolean>() {
            String missmathc = "";
            public Boolean apply(WebDriver input) {
                String actual = (String)((JavascriptExecutor)input).executeScript
                        ("return document.getElementsByClassName('"+className+ "')[" + index+"].value;");
                if(actual.toLowerCase().equals(text.toLowerCase())) return true;
                else{
                    missmathc = actual;
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("String\"" + text + "\" to be present in element's text.\nActual text: \""+missmathc+"\"");
            }

        };
    }



}
