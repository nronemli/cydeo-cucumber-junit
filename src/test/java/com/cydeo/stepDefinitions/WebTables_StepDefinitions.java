package com.cydeo.stepDefinitions;

import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTables_StepDefinitions {

    WebTablesPage webTablesPage = new WebTablesPage();

    @Given("user is on the login page of the web table app")
    public void user_is_on_the_login_page_of_the_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablesPage.username.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablesPage.password.sendKeys(string);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        webTablesPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyTitleContains("orders");
    }


    @When("user enters username {string} and password {string} and logins")
    public void userEntersUsernameAndPasswordAndLogins(String username, String password) {
        webTablesPage.login(username, password);
    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String, String> credentials) {
        //System.out.println("credentials.get(\"username\") = " + credentials.get("username"));
        //System.out.println("credentials.get(\"password\") = " + credentials.get("password"));
        webTablesPage.login(credentials.get("username"), credentials.get("password"));
    }











}
