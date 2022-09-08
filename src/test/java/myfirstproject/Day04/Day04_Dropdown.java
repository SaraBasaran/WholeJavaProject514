package myfirstproject.Day04;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day04_Dropdown {

    /*
        //Go to https://the-internet.herokuapp.com/dropdown
    //1.Create method selectByIndexTest and Select Option 1 using index
    //2.Create method selectByValueTest Select Option 2 by value
    //3.Create method selectByVisibleTextTest Select Option 1 value by visible text
    //4.Create method printAllTest Print all dropdown value
    //5. Verify the dropdown has Option 2 text
    //6.Create method printFirstSelectedOptionTest Print first selected option
    //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
         */

    WebDriver driver;
    Faker faker =new Faker();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void selectByIndex(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //locate the dropdown

        WebElement dropDownElement= driver.findElement(By.id("dropdown"));

        //Create select class

        Select select =new Select(dropDownElement);

        //3.Select any option using select object

        select.selectByIndex(1); //index starts here "0".

    }

    @Test
    public void selectByValue(){

        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Step: locate the dropdown

        WebElement dropDownElement= driver.findElement(By.id("dropdown"));

        //2.Step: Create select class

        Select select =new Select(dropDownElement);

        //3.Step: Select any option by using select object
        select.selectByValue("2"); //here selecting element 2 as it's value is 2.

    }
    public void selectByVisibleText(){

        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Step: locate the dropdown
        WebElement dropDownElement= driver.findElement(By.id("dropdown"));

        //2.Step: Create select class
        Select select =new Select(dropDownElement);

        //3.select by visible text
        select.selectByVisibleText("Option 1");


    }
    //4.Step: Create a new printAllTest method print all dropdown value
       @Test
    public void printAllTest(){

        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Locate the dropdown
           WebElement dropDownElement=  driver.findElement(By.id("dropdown"));

        //Create Select class
        Select select= new Select(dropDownElement);

        //get all of the options
        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption:allOptions){

               System.out.println(eachOption.getText());

           }

        //Verify the dropdown has Option 2 text
           boolean flag=false;
           for (WebElement eachOption:allOptions) {
               //checking if Option 2 is in the dropdown
               //if it is in the dropdown, then flag=true, then assertion will pass
               if (eachOption.getText().equals("Option 2")){
                   flag=true;
                   System.out.println("Option 2 EXISTS");
               }

           }
           Assert.assertTrue(flag);
           //6.Create a method that prints the first selected option
           WebElement firstSelectedOption= select.getFirstSelectedOption();
           System.out.println("Default Selected Option: "+ firstSelectedOption.getText());

           //7.Find the size of the dropdown.Print "Expected Is Not Equal To Actual" if tehre are not 3 elements in the dropdown

           int dropDownSize= allOptions.size();
           System.out.println("Dropdown Size: "+ dropDownSize);

           Assert.assertEquals("Expected Is not Equal To Actual",3, dropDownSize);

       }













}
