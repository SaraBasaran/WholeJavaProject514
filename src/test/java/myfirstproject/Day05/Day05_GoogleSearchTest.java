package myfirstproject.Day05;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day05_GoogleSearchTest extends TestBase {

    @Test
    public void searchTest(){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);

        String result= driver.findElement(By.id("result-stats")).getText();
        System.out.println(result);



    }





}
