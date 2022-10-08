package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {

    public WebTablesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     * no parameters when called it will directly login using username:Test and password:Tester
     */
    public void login() {
        username.sendKeys("Test");
        password.sendKeys("Tester");
        this.loginButton.click(); //use this to refer to this one
    }

    /**
     * accepts two arguments and clicks login
     *
     * @param usernameInput
     * @param passwordInput
     */
    public void login(String usernameInput, String passwordInput) {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginButton.click();
    }

    /**
     * this method will login using credentials from configuration.properties
     */
    public void loginWithConfig() {

        username.sendKeys(ConfigurationReader.getProperty("webTable.username"));
        password.sendKeys(ConfigurationReader.getProperty("webTable.password"));
        loginButton.click();
    }


}
