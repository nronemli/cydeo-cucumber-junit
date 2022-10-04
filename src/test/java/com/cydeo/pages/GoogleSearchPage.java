package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    //create a constructor
    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //find web elements using the findBy annotation
    @FindBy(name = "q")
    public WebElement searchBox;


    //@FindBy(id = "L2AGLb")
    @FindBy(xpath = "//button[@id='L2AGLb']/div")
    public WebElement acceptButton;

}
