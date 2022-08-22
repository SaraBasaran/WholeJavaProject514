package myfirstpackage;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_Radiobutton {

    /*
    TEST CASE:
        Click on Create new account
        Enter first name
        Enter last name
        Enter mobile number or email
        Enter new password
        Enter birthday(LATER)
        Enter gender
        Click Sign Up
        9:22
        Create a class : RadioButton
        Complete the following task.
        Go to https://www.facebook.com/
        Click on Create an Account button
        Locate the elements of radio buttons
        Then click on the radio buttons for your gender if they are not selected
     */

    WebDriver driver;
    Faker faker =new Faker();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }
    @Test
    public void accountSignUp(){

        driver.get("https://www.facebook.com/");

        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        driver.findElement(By.xpath("//input[@placeholder='Adın']")).sendKeys(faker.name().firstName());

        //input area-label= 'Soyadın'
        driver.findElement(By.xpath("//input[@aria-label='Soyadın']")).sendKeys(faker.name().lastName());

        driver.findElement(By.xpath("//input[@aria-label='Cep telefonu numarası veya e-posta']")).sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys(faker.number().digits(8));

        //        Jan 10 2000
        //        MONTH

        WebElement year= driver.findElement(By.xpath("//select[@aria-label='Yıl']"));
        Select selectYear= new Select(year);
        selectYear.selectByValue("2000");

        //        1. locate the month dropdown
                WebElement month = driver.findElement(By.xpath("//select[@aria-label='Ay']"));
        //        2. create select
                Select selectMonth=new Select(month);
        //        3. select your option using select object
                 selectMonth.selectByVisibleText("Oca");

        WebElement day = driver.findElement(By.xpath("//select[@aria-label='Gün']"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("10");

        //class="_8esa"
        driver.findElement(By.xpath("//input[@type='radio']")).click();
//        Select selectGender= new Select(gender);
//        selectGender.selectByVisibleText("Kadın");

        driver.findElement(By.name("websubmit")).click();


    }






}
