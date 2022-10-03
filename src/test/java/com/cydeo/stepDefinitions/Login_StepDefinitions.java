package com.cydeo.stepDefinitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.sound.midi.Soundbank;

public class Login_StepDefinitions {

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("user enters librarian username");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("user enters librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("user should see the dashboard");
    }

    //run Runner class, auto generate our snippets
    //we can hover over the feature file and select option provided
    @When("user enters student username")
    public void user_Enters_Student_Username() {
        System.out.println("user enters student username");
    }

    @And("user enters student password")
    public void user_Enters_Student_Password() {
        System.out.println("user enters student password");
    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("user enters admin username");
    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("user enters admin password");
    }

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        System.out.println("User is on the library login page");
    }


}
