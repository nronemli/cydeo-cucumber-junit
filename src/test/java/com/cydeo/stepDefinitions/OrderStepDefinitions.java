package com.cydeo.stepDefinitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class OrderStepDefinitions {

    WebTablesPage webTablesPage = new WebTablesPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //calling our login method in the web table app
      Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTablesPage.loginWithConfig();
        //clicking order page from basepage(which has all the webelements of baseoafge)
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropDown);
        select.selectByVisibleText(string);
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {

    }

    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {

    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {

    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {

    }

    @When("user enters credit card type {string}")
    public void user_enters_credit_card_type(String string) {

    }

    @When("user enters credit cart number {string}")
    public void user_enters_credit_cart_number(String string) {

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {

    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String string) {
    }


}
