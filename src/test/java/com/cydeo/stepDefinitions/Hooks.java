package com.cydeo.stepDefinitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to pass pre& post condition to each scenario and each step
 */
public class Hooks {
    //import from io.cucumber.java not junit
    @Before
    public void setUpScenario() {
        System.out.println("++++++++Setting up browser using cucumber @Before");
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        //if scenario fails this method will take screenshot and save it
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep() {
        System.out.println("-------> Applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("-------> Applying tearDown using @AfterStep");
    }

}
