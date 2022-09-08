package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization2 extends TestBase {

    /*
    Homework 1:
    Create a class:Synchronization2.
    Create a method: synchronization2
    Go to https://the-internet.herokuapp.com/dynamic_loading/2
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen
     */

    @Test
    public void synchronization2() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.id("start")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait does 2 things 1)waits for the element 2)returns the webElement so no need to use findElement()

        Thread.sleep(5000);
        boolean helloWorld= wait.until(ExpectedConditions.
                            invisibilityOfElementWithText(By.xpath("//div[@id='finish']//h4"), "Hello World!"));
        //by this way selenium will wait till it finds the element







    }





}
