package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization3 extends TestBase {
    /*
    Homework 2:

    Create a class:Synchronization3. Create a method: synchronization1
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click on remove button
    And verify the message is equal to “It's gone!”
    Then click on Add button
    And verify the message is equal to “It's back!”

    */
    @Test
    public void synchronization1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

       //“It's gone!”

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isGone = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        Assert.assertTrue(isGone);

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        Thread.sleep(10000);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean isBack= wait2.until(ExpectedConditions.textToBe(By.id("message"), "It's back!"));
        Assert.assertTrue(isBack);


    }

















}
