package myfirstpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    //Firstly, this class should know which driver will be used and
    //1.Step: Create a new class for Basic Navigations
    //2.Step: Create main method
    public static void main(String[] args) throws InterruptedException {
        //3.Step: Set driver and path
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    //this way is not totally recommended we can use in this way or we can add driver name directly to pom file
        //**So far we used drivers in our local.We can use WebDriverManager dependency on a maven project.This helps
        //us to setup and use driver faster.This is the second way of using driver(more recommended).From now on, we will
        //use WebDriverManager.For this, go to mvnrepository.com and get the WebDriverManager dependency

        //4.Step: Create chrome driver object
        WebDriver driver= new ChromeDriver();

        //5.Step: Start your test case==>navigate to walmart.com
        driver.get("https://www.youtube.com/."); //get("URL")==>used to to go to a website
        Thread.sleep(3000); //Wait for 3 seconds at this point

        //6.Step: Maximize the window==>to have the website page open in full on the screen
        driver.manage().window().maximize();
        //7.Step: Open Google homepage==>Maximizing the window is imp. bec. users also most of the time wants to see
       // the webpage in full screen, not to make any mistake
        Thread.sleep(3000); //==>if we have a problem about the speed of the access we can tell java
                                 //to wait for a while for the next action.==>Thread.sleep(3000)==>3 seconds
                                 //if you have internet speed problem or pc speed problem.

        //Task:On the same class, Navigate to Amazon home page
        driver.navigate().to("https://amazon.com/"); //==>get() and navigate().to() is almost same
        //but with navigate() we can navigate back and forward and automate this with selenium
        Thread.sleep(3000);

        //Task: Navigate back to Youtube
        driver.navigate().back(); //==>youtube.com
        Thread.sleep(3000);

        //Task:Navigate forward to Amazon
        driver.navigate().forward();
        //Task: Refresh the page
        driver.navigate().refresh();

        //Close/Quit the browser
        //driver.close();
        //OR
        driver.quit();
        /*
       Intv. Q:1) What is the difference between get() and navigate()?
        Similarities: Both opens a page of URL.
        Differences: 1) get() accepts the string url, navigate() can be used with to().
                     2)get() cannot be used to go back, forward and refresh
                       navigate can be used for going back, forward and refresh.
                     3)get() accepts only string urls whereas navigate() accepts string OR URL as parameter.

       Intv. Q:2) What is the difference between close() and quit()?
       Similarities: Both are used to close window.
       Differences:
             driver.close() closes only ACTIVE WORKING WINDOW(ONLY ONE LASTLY OPENED WINDOW)
             driver.quit() closes ALL working windows





         */






    }




}
