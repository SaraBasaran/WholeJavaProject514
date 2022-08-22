package practise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {
    // ...Exercise3...
    // go to url : https://www.techlistic.com/p/selenium-practice-form.html
    //fill the firstname
    //fill the lastname
    //check the gender
    //check the experience
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }
    @Test
    public void test(){
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname==>we need locators to test the name and lastname values
        ////*[@id="post-body-3077692503353518311"]/div[1]/div/div/h2[2]/div[1]/div/div[2]/input OR //input[@name='firstname']

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");

        //fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Doe");

        //Click on cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        //check the gender
        driver.findElement(By.id("sex-0")).click();

        //check the experience
        driver.findElement(By.id("exp-3")).click();

        //fill the date
        driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("19.08.2022");

        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//*[@id='profession-1']")).click();

        //choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();

        //choose your continent -> Antartica
        driver.findElement(By.xpath("//*[@id=continents]")).sendKeys("Antartica");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//*[@id=selenium_commands]/option[1]")).click();

        //click submit button

        driver.findElement(By.id("submit")).click();





    }





















}
