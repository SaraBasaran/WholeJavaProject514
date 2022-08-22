package myfirstpackage;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
xpath axes==> //input[@ attribute=value].following
                                         ancestor
                                         sibling
 */
public class Day_03CheckBox {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //  Locate the elements of checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //  Then click on checkbox1 if box is not selected
        WebElement checkBox1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        //Then click on checkbox2 if box is not selected

       if( !checkBox1.isSelected()){
           checkBox1.click();
       }
       Thread.sleep(3000);

       if (!checkBox2.isSelected()){
           checkBox2.click();
       }
       //Then verify that checkbox1 is checked.
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());
        /*
        isSelected() is used to check if check box or radio button is selected or not.
        If a check box is selected then isSelected() will return true.
        If a check box is not selected then isSelected() will return false.
         */


    }

}
