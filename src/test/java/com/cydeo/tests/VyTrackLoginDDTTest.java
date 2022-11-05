package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.google.gson.stream.JsonToken;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    //junit @before
    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.Url"));
    }

    @Test
    public void loginDDDTest() throws IOException {
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            String userName = sheet.getRow(i).getCell(0).toString();
            String passWord = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();
            loginPage.login(userName, passWord);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            WebElement loaderMask= Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullname = dashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullname.contains(firstName) && actualFullname.contains(lastName)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAILED");
            }
            dashboardPage.logout();
        }
        FileOutputStream outputStream= new FileOutputStream(filePath);
        //save all changes
        workbook.write(outputStream);
        //close all
        inputStream.close();
        outputStream.close();
    }

    //junit @After
    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
