package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class HW extends TestBase {
     /*
            ---Homework---
        // http://the-internet.herokuapp.com/add_remove_elements/
        // click on the "Add Element" button 100 times
        // write a function that takes a number, and clicks the "Delete" button
        // given number of times, and then validates that given number of buttons were deleted
     */

    @Test
    public void test() {
        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
// click on the "Add Element" button 100 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        //driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        if (addElement.isDisplayed()) {
            int counterAdd = 0;
            for (int i = 0; i < 100; i++) {
                addElement.click();
                counterAdd++;
            }
            System.out.println("adding element size: " + counterAdd);
            //Actions actions = new Actions(driver);
//            WebElement delete = driver.findElement(By.xpath("//button[@class='added-manually']"));
//            driver.findElement(By.xpath("//button[@class='added-manually']")).click();
//            driver.findElement(By.xpath("//button[@class='added-manually']")).click();
//            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
            //actions.click().perform();
            // write a function that takes a number, and clicks the "Delete" button given number of times,
            Random number1 = new Random();
            int random = number1.nextInt(100);
            System.out.println("Random number : "+ random);


// and then validates that given number of buttons were deleted
            int counterDelete =0;
            for (int k = 0; k<random; k++){
                driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
                counterDelete++;
            }
            System.out.println("Deleted element size : "+counterDelete);
            Assert.assertEquals(random, counterDelete);
        }
    }
}

