package myfirstproject.Day06;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day06_IFrameTest extends TestBase {

    /*
            Create a class: IFrameTest
        Create a method: iframeTest
        Go to https://the-internet.herokuapp.com/iframe
        Verify the Bolded text contains “Editor”
        Locate the text box
        Delete the text in the text box
        Type “This text box is inside the iframe”
        Verify the text Elemental Selenium text is displayed on the
        page
     */

    @Test
    public void iFrameTest() throws InterruptedException {
      //  Go to https://the-internet.herokuapp.com/iframe
        driver.get(" https://the-internet.herokuapp.com/iframe");  //iframe id="mce_0_ifr"

        //        Verify the Bolded text contains “Editor”

      String pageHeader= driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();

        Assert.assertTrue(pageHeader.contains("Editor"));

//        Locate the text box==>SWITCH TO IFRAME.
       // driver.switchTo().frame(0); ==>works
       // driver.switchTo().frame("mce_0_ifr");works as well
        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        WebElement textBox=driver.findElement(By.xpath("//p"));

//        Delete the text in the text box
          textBox.clear();

          //        Type “This text box is inside the iframe”

        textBox.sendKeys("This text box is inside the iframe");

        //the driver is still in iFrame and we should switch back to the main/parent frame or switch to default frame.
        driver.switchTo().parentFrame();
        //or driver.switchTo().default
        //        Verify the text Elemental Selenium text is displayed on the page

       WebElement elementalSelenium= driver.findElement(By.linkText("Elemental Selenium"));

       Assert.assertTrue(elementalSelenium.isDisplayed());

  }

  @Test
    public void test2(){

      //Go to https://testpages.herokuapp.com/
      driver.get("https://testpages.herokuapp.com/");

      //Click on "iFrames Test Page" under frames
      driver.findElement(By.id("iframestest")).click();
      driver.switchTo().frame(1);
      WebElement headerVerification = driver.findElement(By.xpath("//h1[.='Nested Page Example']"));

      //Assert that it has an iframe with header "iFrames Test Page"
      String headerText= headerVerification.getText();


      Assert.assertTrue(headerText.equals("Nested Page Example"));


      //Assert that it has an iframe with header "iFrames Test Page"






  }
}
