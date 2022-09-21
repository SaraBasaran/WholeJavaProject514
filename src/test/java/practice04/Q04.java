package practice04;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q04 extends TestBase {

    //Go to https://testpages.herokuapp.com/styled/key-click-display-test.html
    //Click on "click me" given number of times.
    //Press space button same given number of times
    //Add all the 2 digit numbers in down buttons(down 32==> add all 32s)
    //Subtract the length of all click texts

    @Test
    public void test(){
        //Go to https://testpages.herokuapp.com/styled/key-click-display-test.html
        driver.get("https://testpages.herokuapp.com/styled/key-click-display-test.html");

        //Click on "click me" given number of times.
        WebElement clickMe = driver.findElement(By.id("button"));

        int number = 50;

        for(int i = 0; i<number; i++){

            clickMe.click();

        }

        //Press space button same given number of times
        Actions actions = new Actions(driver);
        for(int i = 0; i<number; i++){

            actions.sendKeys(Keys.SPACE).perform();

        }

        //Add all the 2 digit numbers in down buttons(down 32==> add all 32s)
        List<WebElement> downKeys = driver.findElements(By.xpath("//p[.=' down 32']"));

        int sumOfNumber = 0;
        for(WebElement w : downKeys){

            sumOfNumber += Integer.valueOf(w.getText().replaceAll("[^0-9]",""));


        }
        System.out.println("sumOfNumber = " + sumOfNumber);


        //Subtract the length of all click texts
        List<WebElement> clicks = driver.findElements(By.xpath("//p[.='click']"));

        int sumOfLength = 0;
        for(WebElement w : clicks){

            sumOfLength += w.getText().length();

        }

        System.out.println("sumOfLength = " + sumOfLength);

        System.out.println("Difference: "+(sumOfNumber-sumOfLength));

        Assert.assertEquals(1100,sumOfNumber-sumOfLength);
    }
}