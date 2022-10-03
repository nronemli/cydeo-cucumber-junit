package com.cydeo.stepDefinitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

/*
In this class we will be able to pass pre& post condition to each scenario and each step
 */
public class Hooks {
    //import from io.cucumber.java not junit
    @Before
    public void setUpScenario(){
        System.out.println("++++++++Setting up browser using cucumber @Before");
    }

    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-------> Applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("-------> Applying tearDown using @AfterStep");
    }
}
