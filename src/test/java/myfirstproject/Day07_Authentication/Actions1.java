package myfirstproject.Day07_Authentication;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions1 extends TestBase {

    @Test
    public void contextClick(){

        /*
        Given user is on the https://the-internet.herokuapp.com/context_menu
        When use Right clicks on the box
        Then verify the alert message is “You selected a context menu”
        Then accept the alert
         */

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //When use Right clicks on the box
        Actions actions=new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        // Then verify the alert message is “You selected a context menu”
        String alertText= driver.switchTo().alert().getText();

        Assert.assertEquals("You selected a context menu", alertText);

        //then accept the alert
        driver.switchTo().alert().accept();




    }



}
