package myfirstproject.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    //Workbook > workSheet > Row > Cell
    @Test
    public void readExcel() throws IOException {
        //Path of the workbook
        String path= "./src/test/java/resources/capitals.xlsx";

        //access the file
        FileInputStream fileInputStream=new FileInputStream(path);

        //Open the workbook

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //Open the first worksheet==> we can get by name or by index

        Sheet sheet1= workbook.getSheetAt(0);//gets the first sheet from excel
        //Sheet sheet1= workbook.getSheet("Sheet1");==> gets the sheet by name

        //Go to the first row
        Row row1=sheet1.getRow(0);

        //go to the first cell
        Cell cell1= row1.getCell(0);

        System.out.println(cell1); //Prints Country

        //Go to row 1 cell 2 and print
        Cell r1c2= row1.getCell(1);
        System.out.println(r1c2);

        //Go to row 2 cell 1 and assert if the data is equal to U.S.A
        String r2c1= sheet1.getRow(1).getCell(0).toString(); //we can make the methods like a chain
        System.out.println(r2c1);
        Assert.assertEquals("U.S.A", r2c1);

        //Go to row3 cell2 - chain the row and cell
        Cell r3c2=sheet1.getRow(2).getCell(1);
        System.out.println(r3c2);

        //find the total number of row
        int numberOfRows= sheet1.getLastRowNum() + 1; //acc. to index
        System.out.println(numberOfRows);//gives the index of lastly used number of rows

        //Find the number of used row
        int physicalRowNum = sheet1.getPhysicalNumberOfRows();
        System.out.println(physicalRowNum); //actually used number of rows==> if row is empty then not counted

        //Print country, capital key value pairs as map object
        Map<String, String > capitals= new HashMap<>();

        for (int rowNum=1; rowNum<numberOfRows; rowNum++) {
            //1.way: creating String

//            String country= sheet1.getRow(rowNum).getCell(0).toString();
//            System.out.println(country);
//            String capital= sheet1.getRow(rowNum).getCell(1).toString();
//            System.out.println(capital);
//            Adding the key value pairs in the map
//            capitals.put(country, capital);

           //2.way: We can shorten like this
            capitals.put(sheet1.getRow(rowNum).getCell(0).toString(), sheet1.getRow(rowNum).getCell(1).toString());
        }
        System.out.println(capitals);




    }
}




