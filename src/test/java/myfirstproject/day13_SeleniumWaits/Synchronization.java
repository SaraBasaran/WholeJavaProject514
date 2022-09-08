package myfirstproject.day13_SeleniumWaits;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization extends TestBase {

    /*
    Create a class:Synchronization
    Create a method: explicitWait
    Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen
     */

    @Test
    public void explicitWait(){
        //        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Then verify the ‘Hello World!’ Shows up on the screen
        //WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
       // String helloWorldText = helloWorld.getText();
        //Assert.assertEquals("Hello World!",helloWorldText); //gives error==>because text is hidden
        /*
        NOTE: This code fails because the Hello World text is hidden for about 5 seconds
        We should wait for the element using explicit wait to be displayed
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        String helloWorldText = helloWorld.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
       */
        // we should use explicit wait to find a hidden element
        //1.Create WebDriverWait object
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait does 2 things 1)waits for the element 2)returns the webElement so no need to use findElement()
        WebElement helloWorld= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        //by this way selenium will wait till it finds the element

        String helloWorldText = helloWorld.getText();
        Assert.assertEquals("Hello World!",helloWorldText);



    }
    //Another method to explicitly wait for hidden element
    @Test
    public void explicitWait1() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Then verify the 'Hello World!' Shows up on the screen

//        1. create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait does 2 things: 1. waits for the locator until the text of the locator matches
//        2. returns true if text matches in 10 seconds, returns false if text does not match in 10 seconds
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
        Assert.assertTrue(isTrue);
    }

    //there are times that we had better use thread.sleep ==>for uploading or downloading files bec. explicit wait cannot see the path


    @Test
    public void fluentWait(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class); //optional but had better type not to get any exception error
        //        2. use object to wait
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorld.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }

    /*
    Homework 1:
    Create a class:Synchronization2.
    Create a method: synchronization2
    Go to https://the-internet.herokuapp.com/dynamic_loading/2
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen

    Homework 2:
    Create a class:Synchronization3. Create a method: synchronization1
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click on remove button
    And verify the message is equal to “It's gone!”
    Then click on Add button
    And verify the message is equal to “It's back!”

    HomeWork 3:1111111111111111111111111111
           Create a class:Synchronization4. Create a method: isEnabled
            Go to https://the-internet.herokuapp.com/dynamic_controls
            Click enable Button
            And verify the message is equal to “It's enabled!”
            And verify the textbox is enabled (I can type in the box)
            And click on Disable button
            And verify the message is equal to “It's disabled!”
            And verify the textbox is disabled (I cannot type in the box)
            NOTE: .isEnabled(); is used to check if an element is enabled or not

     */








    }





