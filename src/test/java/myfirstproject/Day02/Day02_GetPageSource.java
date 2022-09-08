package myfirstproject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        String pageSource=driver.getPageSource();
        System.out.println(pageSource);//whatever on the page is printed, we should do manual test first we can search the required word from pagesource
                                        //on the source page if we type ctrl+F gives the result

        if (pageSource.contains("Registry")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Page Source ==>>" + pageSource);
            System.out.println("EXPECTED WORD REGISTRY");
        }
       // driver.quit();

    }
}
