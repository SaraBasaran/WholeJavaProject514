package myfirstproject.Day08_FileExist;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions04 extends TestBase {

    @Test
    public void dragAndDropTest() {

        driver.get("https://jqueryui.com/droppable/");

        //the elements are inside the frame so switch to it
        driver.switchTo().frame(0);

        //locations of the source and the target are defined By.id
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //use actions to drag the source and drop on the target
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void clickAndHoldTest() {

        driver.get("https://jqueryui.com/droppable/");

        //the elements are inside the frame so switch to it
        driver.switchTo().frame(0);

        //locations of the source and the target are defined By.id
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //use actions to drag the source and drop on the target
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).perform();

        actions.clickAndHold(source).moveByOffset(462, -18).build().perform();

    }
}