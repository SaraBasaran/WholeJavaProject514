package myfirstproject.day10_ScreenShot01;

import myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot2 extends TestBase {

    @Test
    public void takeScreenshotTest() throws IOException {

        driver.get("https://www.techproeducation.com");

    //Take screen shot of a specific element==> logo of techpro

        WebElement logo= driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
       //1. take screen shot
        File image= logo.getScreenshotAs(OutputType.FILE);

      //2.save screenshot
        String currentTime= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       String path= System.getProperty("user.dir") + "/test-output/Screenshots/"+ currentTime+"image.png";
        FileUtils.copyFile(image, new File(path));
    }
    @Test
    public void takeScreenshotTest2() throws IOException {

        driver.get("https://www.techproeducation.com");

        //Take screen shot of a specific element==> logo of techpro

        WebElement logo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        takeScreenShotOfElement(logo);

        //take screenshot of social media section
        WebElement socials= driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenShotOfElement(socials);


    }

    //Create a reusable method
    //@params: Webelement
    //takes screenshot
    public void takeScreenShotOfElement(WebElement element) throws IOException {

        //1. Take screen shot
        File image= element.getScreenshotAs(OutputType.FILE);

        //2.save screenshot
        String currentTime= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path= System.getProperty("user.dir") + "/test-output/Screenshots/"+ currentTime+"image.png";
        FileUtils.copyFile(image, new File(path));


    }


}
