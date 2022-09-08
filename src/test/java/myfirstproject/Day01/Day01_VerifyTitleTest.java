package myfirstproject.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_VerifyTitleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");
        //we should create a String container/object to check the expected and actual title
        //get title
        String actualTitle= driver.getTitle(); //==>returns the page title
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";//PASS

        //Verify if actualTitle = expectedTitle
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("ACTUAL: " + actualTitle);
            System.out.println("EXPECTED: "+ expectedTitle);
            /*
          If typed ==> Techpro Education | Online IT Courses &amp; Bootcamps
            FAIL
            ACTUAL: Techpro Education | Online It Courses & Bootcamps
            EXPECTED: Techpro Education | Online IT Courses &amp; Bootcamps
            We should fix documentation issue; typed wrong.
             */
        }









    }





}
