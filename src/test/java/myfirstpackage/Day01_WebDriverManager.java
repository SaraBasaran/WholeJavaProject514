package myfirstpackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManager {
    public static void main(String[] args) {
        //1.Step: Setup chrome driver
        WebDriverManager.chromedriver().setup(); //instead of using=> System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        //2.Step: Create WebDriver object
        WebDriver driver=new ChromeDriver();
        //3.Type your test case
        driver.get("https://www.amazon.com");//here we use WebDriverAPI






    }
}
