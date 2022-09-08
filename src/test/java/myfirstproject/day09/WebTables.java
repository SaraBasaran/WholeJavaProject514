package myfirstproject.day09;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables extends TestBase {

    @Test
    public void printTable(){

        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1: Print the entire table
        //1.way
        System.out.println("***Print Entire table***");
       String table1=driver.findElement(By.id("table1")).getText();
        System.out.println(table1);

        //2.way: using findElements() and putting all data into a List
        List<WebElement> alldata= driver.findElements(By.id("table1")); //all elements all one by one each row and each cell for each data
        //whenever we have a list we should use for loop

        for(WebElement eachData: alldata){

            System.out.println(eachData.getText());

        }
        System.out.println("10th data in the table "+alldata.get(10).getText());
    }

    //Task 2: Print all rows
    @Test
    public void printAllRows(){

        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print All Rows***");

        List<WebElement> allRows= driver.findElements(By.xpath("//table[@id='table1']//tr"));

        int counter= 1;
        for(WebElement eachRow: allRows){

            System.out.println("Row num: "+ counter+ "==>" +eachRow.getText());
            counter++;
        }
        //since we have all elements one by one in the List, we can tell java that give us one specific row...

        System.out.println("Row 4 data ==> " + allRows.get(3).getText());

        //Task 3: Print last row data only
        //System.out.println("Last Row Data ==>" + allRows.get(4).getText());==>hard coding
        System.out.println("Last Row Data ==>" + allRows.get(allRows.size()-1).getText());

    }
    //Task 4: Print column 5 data in the table body

    @Test
    public void printColumns(){

        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Column 5");

       List<WebElement> column5= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));

       for (WebElement each: column5){
           System.out.println(each.getText());
       }
       }

       @Test
       public void printDataTest(){

           //"//table[@id='table1']//tbody//tr[5]//td[5]
        printData(2,5); //method call for printData.dynamic coding

           //"//table[@id='table1']//tbody//tr[1]//td[2]
        printData(1,2);

        //"//table[@id='table1']//tbody//tr[2]//td[3]

           printData(2,5, "table1");
           printData(4, 5, "table2");

        }
       //Task 5: Write a method that accepts 2 parameters

    public void printData(int rowNum, int colNum){
           driver.get("https://the-internet.herokuapp.com/tables");
           String xPath= "//table[@id='table1']//tbody//tr["+ rowNum+ "]//td["+ colNum+"]";

           //"//table[@id='table1']//tbody//tr[2]//td[3]

           WebElement targetElement= driver.findElement(By.xpath(xPath));

        System.out.println(targetElement.getText());


       }

       public void printData(int rowNum, int colNum, String tableID){

           driver.get("https://the-internet.herokuapp.com/tables");
           String xPath= "//table[@id='"+tableID+"']//tbody//tr["+ rowNum+ "]//td["+ colNum+"]";

           WebElement targetElement= driver.findElement(By.xpath(xPath));

           System.out.println(targetElement.getText());

       }


}
