package practice04;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q03 extends TestBase {

    //Go to https://testpages.herokuapp.com/
    //Click on File Downloads
    //Click on Server Download
    //Verify that file is downloaded
    @Test
    public void test(){
        //Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

        //Click on File Downloads
        driver.findElement(By.id("download")).click();

        //Click on Server Download
        driver.findElement(By.id("server-download")).click();

        //Verify that file is downloaded
        String filePath = System.getProperty("user.home")+"/Downloads/textfile.txt";
        System.out.println(filePath);
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);
    }
}