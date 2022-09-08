package myfirstproject.Day06;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;


public class Day06_WindowHandle extends TestBase {

    /*
            Given user is on the https://the-internet.herokuapp.com/windows
        Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the “Click Here” button
        Then user verifies the new window title is “New Window”
        Then user verifies the text: “New Window”
        When user goes back to the previous window and then verifies the title : “The Internet”
    */

  @Test
    public void windowHandle() throws InterruptedException {

      //Given user is on the https://the-internet.herokuapp.com/windows
      driver.get("https://the-internet.herokuapp.com/windows");

      //Then user verifies the text : “Opening a new window”
     WebElement text= driver.findElement(By.xpath("//h3[.='Opening a new window']"));

      Assert.assertTrue(text.getText().equals("Opening a new window"));
      //Then user verifies the title of the page is “The Internet”
      String title1= driver.getTitle();
      Assert.assertTrue(title1.equals("The Internet"));
       //GET WINDOW 1 HANDLE
      String windowHandle= driver.getWindowHandle();
      System.out.println(windowHandle);
      //When user clicks on the “Click Here” button
      driver.findElement(By.linkText("Click Here")).click();

      //        NEW TAB OPENS. SO WE NEED TO SWITCH TO THAT WINDOW TO PERFORM TEST ON THE PAGE

      Set<String> allWindows = driver.getWindowHandles();//[CDwindow-2415A8DC07D74C47536A62141422B3C2, CDwindow-F6D3E56141C5B57FF1852E6B60F69880]
      System.out.println(allWindows);

      for(String eachHandle : allWindows){

          if(!eachHandle.equals(windowHandle)){

              driver.switchTo().window(eachHandle); //This will take driver to the next page
              break;
          }

      }

//        Then user verifies the new window title is "New Window"

      String title2 = driver.getTitle();
      Assert.assertTrue(title2.equals("New Window"));

//        Then user verifies the text: "New Window"
      String text2 = driver.findElement(By.xpath("/html/body/div/h3")).getText();
      Assert.assertTrue(text2.equals("New Window"));

//        When user goes back to the previous window and then verifies the title : "The Internet"
      driver.switchTo().window(windowHandle);
      String title1Second = driver.getTitle();
      Assert.assertTrue(title1Second.equals("The Internet"));

      //Verify the window2 URL is https://the-internet.herokuapp.com/window/new

      String window2URL= driver.getCurrentUrl();
      Assert.assertEquals("https://the-internet.herokuapp.com/windows/new", window2URL);
      String window2Handle= driver.getWindowHandle();

      //GO BACK TO WINDOW1 AND PRINT URL
      driver.switchTo().window(windowHandle);
      System.out.println(driver.getCurrentUrl());
      Thread.sleep(2000);

      //GO BACK TO WINDOW2 AND PRINT THE URL

      driver.switchTo().window(window2Handle);
      System.out.println(driver.getCurrentUrl());
      Thread.sleep(2000);

      //GO BACK TO WINDOW1 AND PRINT THE URL

      driver.switchTo().window(windowHandle);
      System.out.println(driver.getCurrentUrl());
      Thread.sleep(2000);

      //GO BACK TO WINDOW2 AND PRINT THE URL

      driver.switchTo().window(window2Handle);
      System.out.println(driver.getCurrentUrl());
      Thread.sleep(2000);















  }



}
