package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {



    @Test
    public void read_from_excel_file() throws IOException {
        String path="Employee.xlsx";

        //to read from excel we need to load it to FileInpuit stream
        FileInputStream file = new FileInputStream(path);
        //workbook>sheet>row>cell
        //create a workbook
        XSSFWorkbook workbook= new XSSFWorkbook(file);
        //we need to get specific sheet from open workbook
        XSSFSheet sheet = workbook.getSheet("Employee");
        //select row and cell
        //print out necip cell , index starts from 0 for row and cell
        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(2).getCell(2));

        //getPhysicalNumberOfRows : returns the count of used cells only
        //starts counting from 1
        int usedRows= sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //returns the number from top cell to bottom cell
        //it doesnt care if the cell is empty or not.
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        //TODO: Create a logic to print 3rd persons name

        for(int rowNum=0;rowNum<usedRows;rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Selim")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: Create a logic to print out Nurs Job ID
        //check if name is Linda --> print out Job_ID of Linda
        for (int rowNum=0; rowNum<usedRows;rowNum++){
        if(sheet.getRow(rowNum).getCell(0).toString().equals("Emin")){
            System.out.println("Emin job ID is: "+sheet.getRow(rowNum).getCell(2));
        }
        }







    }
}
