package practice04;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q01 extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    //Click on "click me" button
    //Verify that "Event Triggered"

    @Test
    public void test() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //Click on "click me" button
        Thread.sleep(4000);
        driver.findElement(By.id("growbutton")).click();

        //Verify that "Event Triggered"
        String eventTriggered = driver.findElement(By.id("growbuttonstatus")).getText();
        Assert.assertEquals("Event Triggered",eventTriggered);
    }
}