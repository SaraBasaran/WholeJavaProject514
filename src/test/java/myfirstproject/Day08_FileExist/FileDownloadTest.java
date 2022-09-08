package myfirstproject.Day08_FileExist;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

     @Test
     public void downLoadTest() throws InterruptedException {

         driver.get("https://the-internet.herokuapp.com/download");

         driver.findElement(By.linkText("usa.png")).click(); //downloads the image

         //verify if the file downloaded or not

         Thread.sleep(3000);
         String homeDirectory= System.getProperty("user.home");

         String path= "/Users/BEKİR/Downloads";

         boolean isDownLoaded= Files.exists(Paths.get(path));
         Assert.assertTrue(isDownLoaded);


     }



}
