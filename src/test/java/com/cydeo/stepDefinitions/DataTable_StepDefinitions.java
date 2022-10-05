package com.cydeo.stepDefinitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTable_StepDefinitions {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
    }

    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List<String> expectedMonths) {

        /*System.out.println("expectedMonths = " + expectedMonths);
        //create a select object
        Select select = new Select(dropdownsPage.month);
        //list of all actualMonth<options> as a web element
        List<WebElement> options = select.getOptions();
        //list of all month <options> as string
        List<String> actualOptionsAsString = new ArrayList<>();
        //iterate options and look at each option
        for (WebElement eachOption : options) {
            actualOptionsAsString.add(eachOption.getText()); //store each options text and store them to String list
        }
        //Assert will check the size of the list first, if its matching itr will check content 1 by 1.
        Assert.assertEquals(expectedMonths,actualOptionsAsString);
   */
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.month);
       Assert.assertEquals(expectedMonths,actualMonths);
    }
}
