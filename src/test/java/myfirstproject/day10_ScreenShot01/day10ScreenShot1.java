package myfirstproject.day10_ScreenShot01;

import myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class day10ScreenShot1 extends TestBase {

    @Test
    public void takeScreenShotTest() throws IOException {
       //driver.get("https://techproeducation.com");
        driver.get("https://www.amazon.com/ca");
        takeScreenShot();
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Porcelain Teapot" + Keys.ENTER);
       takeScreenShot();

        System.out.println(System.getProperty("user.dir")); //this will give the current file directory=>C:\Users\BEK�R\IdeaProjects\SeleniumProject


    }

    public void takeScreenShot() throws IOException {

        //1.Step:Take ScreeShot
        //1.way:
        File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//just captures the screenshot does not save it

        //2.way:We can alternatively do same code in 2 lines
        //TakesScreenshot ts= (TakesScreenshot)driver;
       // File image= ts.getScreenshotAs(OutputType.FILE);

        //3.Step: To make code more readable we can assign names to png files with date format
        //getting the current time as String to use in the screenshot name, so that the names will not let confusion
        String currentTime= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //2.Step: Save screenshot==>we can use target folder in java project part or we can create a new folder in the
        //project level ==> Path of screenshot save folder
        String path= System.getProperty("user.dir")+ "/report/Screeshots/"+currentTime+"image.png";
        //=>by using this method selenium will create report folder for screenshots
        FileUtils.copyFile(image, new File(path));



    }















}
