package com.cydeo.stepDefinitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on the google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user clicks on accept button")
    public void user_clicks_on_accept_button() {
        googleSearchPage.acceptButton.click();
    }

    @When("user types apple in google search box and clicks enter")
    public void user_types_apple_in_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("user sees apple in google title")
    public void user_sees_apple_in_google_title() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is not as expected",expectedTitle,actualTitle);
    }

    @When("user types {string} in google search box and clicks enter")
    public void user_types_in_google_search_box_and_clicks_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string+Keys.ENTER);
    }
    @Then("user sees {string} in google title")
    public void user_sees_in_google_title(String string) {
        String expectedTitle = string+" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is not as expected",expectedTitle,actualTitle);
    }










}
