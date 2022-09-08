package myfirstproject.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {
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

        //Create a cell on the 3rd column(2nd index) on the first row
        Cell r1c3= row1.createCell(2);

        //Write "POPULATION" on that cell
        r1c3.setCellValue("POPULATION");

        //Create a cell on the 2nd row and 3rd cell and write 15000
        sheet1.getRow(1).createCell(2).setCellValue("150000");

        //Create a cell 3rd row 3rd cell(index 2) and write "250000"
        sheet1.getRow(2).createCell(2).setCellValue("250000");

        //Create a cell on the 4th row 3rd cell(index2) and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");

        //Write and save the changes on the document
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        fileOutputStream.close();

        //close the workbook
        workbook.close();




    }


}
