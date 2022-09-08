package myfirstproject.practise;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q04 extends TestBase {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Match the capitals by country.
    @Test
    public void test(){
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Match the capitals by country.

        //Capitals:
        Actions actions = new Actions(driver);
        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));

        //Countries:
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement sweden = driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement usa = driver.findElement(By.xpath("//div[@id='box103']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement sKorea = driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));


        actions
                .dragAndDrop(oslo,norway)
                .dragAndDrop(stockholm,sweden)
                .dragAndDrop(washington,usa)
                .dragAndDrop(copenhagen,denmark)
                .dragAndDrop(seoul,sKorea)
                .dragAndDrop(rome,italy)
                .dragAndDrop(madrid,spain)
                .perform();

    }
}