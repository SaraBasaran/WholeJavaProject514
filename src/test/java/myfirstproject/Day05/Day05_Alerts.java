package myfirstproject.Day05;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Day05_Alerts extends TestBase {
    /*
    Intv. Que: What is alerts?
    Alerts are pop-ups that are created by javascript. When there is alert, we must handle them.Otherwise, we cannot continue to the test execution.
    --How do you handle alerts?
    First we cannot inspect alerts.We should first switch to the alert and use accept() to click ok, dismiss to click cancel, sendKeys to type,
     getText() to get the text from the alert.
     **For ex;
     User story: When user uses click on info button, then the user should see a msg on the alert.
     Mesg: Office will be closed on Monday.
     **If the story is new the dev team will inform us.
     **If there is already an alert, you need to do manual testing for that alert.
            Go to https://the-internet.herokuapp.com/javascript_alerts
        Create a class: AlertTest
        Create setUp method
        Create 3 test methods:
        acceptAlert() => click on the first alert,
        verify the text “I am a JS Alert” ,
        click OK ,
        and Verify “You successfully clicked an alert”
        dismissAlert()=> click on the second alert,
        verify text "I am a JS Confirm”,
        click cancel,
        and Verify “You clicked: Cancel”
        sendKeysAlert()=> click on the third alert,
        verify text “I am a JS prompt”,
        type “Hello World”,
        click OK,
        and Verify “You entered: Hello World”
     */


    @Test
    public void acceptAlert() throws InterruptedException {
//        Create setUp method
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        Create 3 test methods:

//        acceptAlert() => click on the first alert,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//                verify the text “I am a JS Alert” ,
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);
//        click OK ,
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

      //verify
        String result= driver.findElement(By.xpath("p//[@id='result']")).getText();
        assertEquals("You successfully clicked an alert", result);

    }

    //dismiss alert
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //    dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //    verify text "I am a JS Confirm”,
        String text = driver.switchTo().alert().getText();
        assertEquals("I am a JS Confirm",text);
        //    click cancel,
        driver.switchTo().alert().dismiss();
        //    and Verify “You clicked: Cancel”
        String  result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        assertEquals("You clicked: Cancel",result);

    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //    sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //    verify text “I am a JS prompt”,
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",text);
        //    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
        //    click OK,
        driver.switchTo().alert().accept();
        //    and Verify “You entered: Hello World”
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered: Hello World",result);

    }


//        and Verify “You entered: Hello World”



    }



