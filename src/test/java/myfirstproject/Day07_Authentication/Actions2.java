package myfirstproject.Day07_Authentication;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions2 extends TestBase {

    @Test
    public void hoverOverTest(){

        /*
        Given user is on the https://www.amazon.com/
        When use click on “Account” link
        Then verify the page title contains “Your Account”
         */
     driver.get(" https://www.amazon.com/ca");
     WebElement accountList= driver.findElement(By.id("nav-link-accountList"));
     Actions actions=new Actions(driver);
     actions.moveToElement(accountList).perform();
     driver.findElement(By.linkText("Account")).click();

     //Then verify the title
     String title= driver.getTitle();
        Assert.assertEquals("Your Account", title);



    }


}
