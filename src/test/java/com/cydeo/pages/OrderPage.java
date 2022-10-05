package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "product")
    public WebElement productDropDown;

   // @FindBy()
    public WebElement quantity;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement pricePerUnit;

    public WebElement discount;

    public WebElement total;

    public WebElement customerName;

    public WebElement street;

    public WebElement city;

    public WebElement state;

    public WebElement zip;














}
