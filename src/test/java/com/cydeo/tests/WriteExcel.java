package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    String filePath = "Employee.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet("Employee");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");
        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(12000);
        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary1.setCellValue(22000);
        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary1.setCellValue(18000);
        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary1.setCellValue(19000);

        //TODO: Change Necips last name to "House"
        for (int rowNum=0; rowNum< sheet.getLastRowNum(); rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Necip"));
            sheet.getRow(rowNum).getCell(1).setCellValue("House");
        }
        System.out.println("sheet.getRow(1).getCell(3) = " + sheet.getRow(0).getCell(1));

        //save changes
        //open to write to the file : FileInputStream -->reading
        //write and save : FileOutputStream -->writing
        FileOutputStream outputStream = new FileOutputStream(filePath);

        //save /write changes to the workbook
        workbook.write(outputStream);

        //close all
        outputStream.close();
        workbook.close();
        file.close();
    }


}
