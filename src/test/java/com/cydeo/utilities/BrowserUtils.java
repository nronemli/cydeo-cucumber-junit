package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    /*
      This method will accept int(in seconds) and execute
      Thread.sleep for given seconds
       */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;

            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    //creating a utility method for explicit wait so we dont have
    //to repeat lines
    public static void waitForInvisibilityOf(WebElement webElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will accept a String as expected value and verifty actual URL contains the value
     *
     * @param expectedInTitle
     */
    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInTitle));
    }
    /**
     * This method will accept a dropdown as a webElement and return all the options text in a List of String
     * @param dropdownElement
     * @return
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement eachOption : options) {
            actualOptionsAsString.add(eachOption.getText()); //store each options text and store them to String list
        }
        return actualOptionsAsString;
    }
    /**
     * This method will accept a group of radio buttons as a List of WebElements,
     * It wil loop through the List, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement>radioButtons,String attributeValue){
        for (WebElement eachButton : radioButtons) {
            if (eachButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachButton.click();
            }
        }
    }




}

