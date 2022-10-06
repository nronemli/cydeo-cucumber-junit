package com.cydeo.stepDefinitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTablesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderStepDefinitions {

    WebTablesPage webTablesPage = new WebTablesPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

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


    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
        orderPage.customerName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.street.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.city.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.state.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.zip.sendKeys(string);
    }


    @When("user enters credit cart number {string}")
    public void user_enters_credit_cart_number(String string) {
        orderPage.cardNumber.sendKeys(string);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardeExDate.sendKeys(string);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedName) {
        System.out.println("viewAllOrdersPage.newCustomerCell.getText() = " + viewAllOrdersPage.newCustomerCell.getText());
        String actualName= viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedName,actualName);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        //orderPage.quantity.sendKeys(arg0+"");
        //sendKeys method only accepts string, we need to either concat with ""
        //or send String.valueOf(int)
        orderPage.quantity.clear(); //clears the input box
        orderPage.quantity.sendKeys(String.valueOf(arg0));
    }

    @And("user enters credit card type {string}")
    public void userEntersCreditCardType(String expectedCardType) {
       /* List<WebElement> cardTypes = orderPage.cardType;

        for (WebElement eachButton : cardTypes) {
            if (eachButton.getAttribute("value").equalsIgnoreCase(expectedCardType)) {
                eachButton.click();
            }
        }
        */
        //this line will loop through the list and dcide which radio button to click
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);
    }


}



