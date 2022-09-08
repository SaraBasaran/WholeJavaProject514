package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFrameTest extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {


//● When a user goes to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");

//● Then click on the first video play to play the video

        Thread.sleep(5000);
        WebElement youtube = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
       Thread.sleep(5000);
        driver.switchTo().frame(youtube);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        Thread.sleep(6500);
        driver.findElement(By.xpath("//button[@title='Duraklat (k)']")).click();

    }
}