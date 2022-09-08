package myfirstproject.Day06;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day06_WindowHandle2 extends TestBase {

    @Test
    public void newWindowTest() throws InterruptedException {
        //With Selenium 4, we are able to create and switch to new windows or tabs
       // driver.switchTo().newWindow(WindowType.TAB);
       // driver.switchTo().newWindow(WindowType.WINDOW);

  //Open techpro on Window1
    driver.get("https://www.techproeducation.com");
        System.out.println("TechPro Title: " + driver.getTitle());
        String techProHandle= driver.getWindowHandle();

        Thread.sleep(5000);

  //      Open amazon on a new window2
        driver.switchTo().newWindow(WindowType.WINDOW); //creates and switches to a new window
        driver.get("https://www.amazon.com/ca");
        System.out.println("Amazon Title: " + driver.getTitle());
        String amazonHandle= driver.getWindowHandle();


  //  Open LinkedIn on a new Window
        Thread.sleep(5000);

         driver.switchTo().newWindow(WindowType.WINDOW);
         driver.get("https://linkedin.com");
        System.out.println("LinkedIn Title: " + driver.getTitle());
        String linkedInHandle= driver.getWindowHandle();

        //Switch back to techpro
        Thread.sleep(2000);
        driver.switchTo().window(techProHandle);

        //Switch amazon page
        Thread.sleep(2000);
        driver.switchTo().window(amazonHandle);

        //Switch linkedIn page
        Thread.sleep(2000);
        driver.switchTo().window(linkedInHandle);

        Thread.sleep(1000);
      //  driver.quit();
    }
    @Test
    public void newTabtest() throws InterruptedException {


        //Open techproeducation on window1
        driver.get("https://techproeducation.com");
        String techProTitle= driver.getTitle();
        System.out.println(techProTitle);
        String techProHandle= driver.getWindowHandle();

        //Open youtube on new tab2
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://youtube.com");
        String youTubeTitle= driver.getTitle();
        System.out.println("youTubeTitle = " + youTubeTitle);
        String youTubeHandle=driver.getWindowHandle();

        //Switch back to Techpro
        Thread.sleep(2000);
        driver.switchTo().window(techProHandle);
        //Switch back to youtube page
        Thread.sleep(3000);
        driver.switchTo().window(youTubeHandle);

        driver.quit();

    }

}
