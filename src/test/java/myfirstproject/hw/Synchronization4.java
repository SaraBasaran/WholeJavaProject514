package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Synchronization4 extends TestBase {

   /*
    HomeWork 3:
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
    @Test

    public void isEnabled(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isEnabledEle = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        Assert.assertTrue(isEnabledEle);

        //And verify the textbox is enabled (I can type in the box)
        //input[@type="text"]

        WebElement textBoxEnabled= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBoxEnabled.isEnabled());
        setValueByJS(textBoxEnabled, "I can type in the box");

        //button[@onclick='swapInput()']
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isDisabled = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's disabled!"));
        Assert.assertTrue(isDisabled);

        WebElement textBoxDisabled= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse("The textBox is disabled", textBoxDisabled.isEnabled());

   }

}
