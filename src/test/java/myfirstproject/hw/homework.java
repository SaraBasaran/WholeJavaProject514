package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class homework extends TestBase {

    @Test

    public void clickTest() {
        // Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Click on the "Add Element" button 100 times
        int counterAdd = 0;
        for (int i = 1; i <= 100; i++) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
            counterAdd++;
        }
        System.out.println("counterAdd " + counterAdd);

        // Write a function that takes a number, and clicks the "Delete" button given number of times
        Random rnd = new Random();
        int random = rnd.nextInt(100);
        System.out.println("Random number " + random);

        // Then validates that given number of buttons were deleted
        int counterDelete = 0;
        for (int k = 1; k <= random; k++) {
            driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
            counterDelete++;
        }
        System.out.println("counterDelete " + counterDelete);

        Assert.assertEquals(random, counterDelete);

    }
}
