package practice04;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q02 extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    @Test
    public void test(){
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        driver.findElement(By.id("onblur")).click();
        driver.findElement(By.id("onclick")).click();
        driver.findElement(By.id("onclick")).click();

        WebElement contextMenu = driver.findElement(By.id("oncontextmenu"));
        WebElement doubleClick = driver.findElement(By.id("ondoubleclick"));
        WebElement onFocus = driver.findElement(By.id("onfocus"));
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));
        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));
        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));


        Actions actions = new Actions(driver);

        actions.
                contextClick(contextMenu).
                doubleClick(doubleClick).
                click(onFocus).
                click(onKeyDown).
                sendKeys(Keys.ENTER).
                click(onKeyUp).
                sendKeys(Keys.ENTER).
                click(onKeyPress).
                sendKeys(Keys.ENTER).
                moveToElement(onMouseOver).
                moveToElement(onMouseLeave).
                moveToElement(onMouseOver).
                click(onMouseDown).
                perform();

        List<WebElement> clickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']"));

        Assert.assertEquals(11, clickedButtons.size());
        driver.quit();
    }
}