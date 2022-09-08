package myfirstproject.hw;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignInHomework {
    WebDriver driver;
    Faker faker = new Faker();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    //    @After
//    public void tearDown(){
//        driver.quit();
//    }
    @Test
    public void signIn() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //String mockEmail = faker.internet().safeEmailAddress();

        String mockEmail = "roger.jacobson@hotmail.com";

        driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(mockEmail);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='SubmitCreate']"));


        //Verify the Text: CREATE AN ACCOUNT
        Thread.sleep(5000);
        String actualTitle = driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
        String expectedTitle = "CREATE AN ACCOUNT";

        Assert.assertEquals(expectedTitle, actualTitle);

        Thread.sleep(5000);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(20000);

        //Verify the Text: YOUR PERSONAL INFORMATION
        String subTitle = driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
        Assert.assertEquals("YOUR PERSONAL INFORMATION", subTitle);

        Thread.sleep(15000);
        //Verify the text: Title
        String title= driver.findElement(By.xpath("//label[1]")).getText();
        Assert.assertEquals("Title", title);

        //Select your title

        WebElement selectGender;
          selectGender=driver.findElement(By.xpath("//input[@ id='id_gender2']"));
          selectGender.click();

          //Enter your first name

        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Rodger");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Jacobson");
        //driver.findElement(By.xpath("//input [@name='email']")).sendKeys(mockEmail);
        driver.findElement(By.xpath("//input[@ name='passwd']")).sendKeys("12345678!");

        //Select birthday
        Thread.sleep(5000);
        WebElement dropDownElement1=  driver.findElement(By.id("days"));
        Thread.sleep(3000);
        Select selectDays= new Select(dropDownElement1);
        Thread.sleep(3000);
        selectDays.selectByIndex(14);

        Thread.sleep(5000);
        WebElement dropDownElement2= driver.findElement(By.xpath("//select [@id='months']"));
        Thread.sleep(3000);
        Select selectMonth= new Select(dropDownElement2);
        Thread.sleep(3000);
        selectMonth.selectByIndex(12);

        Thread.sleep(5000);
        WebElement dobYear= driver.findElement(By.xpath("//select [@id='years']"));
        Thread.sleep(3000);
        Select selectYear= new Select(dobYear);
        Thread.sleep(3000);
        selectYear.selectByIndex(39);

        driver.findElement(By.xpath("//input [@ id='newsletter']")).click();

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TechPro Education");

        Thread.sleep(3000);
        //String mockAddress= faker.address().city();
        String mockAddress="Port Billyfort";
        System.out.println(mockAddress);

        driver.findElement(By.xpath("//input[@ name='address1']")).sendKeys(mockAddress);

        Thread.sleep(3000);
        //String mockfullAddress= faker.address().fullAddress();
        //System.out.println(fullAddress);

        String mockfullAddress="Apt. 842 34285 Jeremy Square, Connellyhaven, NC 44400";
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys(mockfullAddress);

        driver.findElement(By.name("city")).sendKeys(mockAddress);

        Thread.sleep(3000);
        WebElement state= driver.findElement(By.xpath("//select[@name='id_state']"));

        Select selectState=new Select(state);
        Thread.sleep(3000);
        selectState.selectByVisibleText("Texas");

        Thread.sleep(2000);
       // String mockPostCode=faker.address().zipCode();
        String mockPostCode="94169";
        System.out.println(mockPostCode);

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(mockPostCode);

        String mockAddInfo="All is well";

        driver.findElement(By.id("other")).sendKeys(mockAddInfo);

       // String mockHomePhone= faker.phoneNumber().phoneNumber();
         String mockHomePhone= "(001) 648-2236 9929";
         driver.findElement(By.name("phone")).sendKeys(mockHomePhone);

        //String mockMobile= faker.phoneNumber().cellPhone();
        String mockMobile="937-343-8512";
        driver.findElement(By.name("phone_mobile")).sendKeys(mockMobile);

        String mockAlias=faker.address().secondaryAddress();
                System.out.println(mockAlias);
        driver.findElement(By.id("alias")).sendKeys(mockAlias);

       driver.findElement(By.name("submitAccount")).click();

      WebElement header1= driver.findElement(By.xpath("//h1 [@class='page-heading']"));
      Assert.assertTrue(header1.isDisplayed());
    }
}
























