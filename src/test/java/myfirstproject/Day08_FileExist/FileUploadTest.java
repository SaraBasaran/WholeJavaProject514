package myfirstproject.Day08_FileExist;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest(){

        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //When user selects an image from the desktop
        String filePath= "C:/Users/BEKİR/Desktop/techpro files/TechProEd Picture-4.jpeg";

        //Click on the upload button

        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(filePath);

        //click on upload button
         WebElement uploadButton= driver.findElement(By.id("file-submit"));
         uploadButton.click();

         //Verify the message "File Uploaded!" displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText().equals("File Uploaded!"));




    }

}
