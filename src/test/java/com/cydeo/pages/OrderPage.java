package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "product")
    public WebElement productDropDown;

    @FindBy(name = "quantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement pricePerUnit;

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(name = "zip")
    public WebElement zip;

    @FindBy(name="card")
    public List<WebElement> cardType;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement cardeExDate;

    @FindBy(xpath = "//button[text()='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//button[text()='Reset Fields']")
    public WebElement resetButton;


    
}
