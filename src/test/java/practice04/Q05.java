package practice04;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q05 extends TestBase {
        //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        //Fill the username, password and textArea comment:
        //Choose a file and upload it
        //Select checkbox, radio item and dropdowns
        //Click on submit
        //Verify that uploaded file name is on the Form Details.
        @Test
        public void test(){

            //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
            driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

            //Fill the username, password and textArea comment:
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");
            WebElement commentBox = driver.findElement(By.xpath("//textarea[@name='comments']"));
            commentBox.clear();
            commentBox.sendKeys("Hello, this is my comment here");

            //Choose a file and upload it
            String filePath = "C:/Users/BEKİR/Desktop/img01.png";
            driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(filePath);

            //Select checkbox, radio item and dropdowns
            WebElement checkBox1 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[1]"));
            WebElement checkBox2 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[2]"));
            WebElement checkBox3 = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[3]"));

            if(!checkBox1.isSelected()){
                checkBox1.click();
            }
            if(checkBox2.isSelected()){
                checkBox2.click();
            }
            if(checkBox3.isSelected()){
                checkBox3.click();
            }

            driver.findElement(By.xpath("//input[@value='rd3']")).click();

            driver.findElement(By.xpath("//option[@value='ms4']")).click();

            WebElement dropDown = driver.findElement(By.xpath("//select[@name='dropdown']"));
            Select select = new Select(dropDown);
            select.selectByValue("dd1");

            //Click on submit
            driver.findElement(By.xpath("//input[@type='submit']")).click();

            //Verify that uploaded file name is on the Form Details.
            WebElement fileName = driver.findElement(By.id("_valuefilename"));

            Assert.assertEquals("img01.png",fileName.getText());

        }
    }

