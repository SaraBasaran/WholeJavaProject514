package myfirstproject.practise;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05 extends TestBase {

    @Test
    public void test() {

        //Go to Facebook
        driver.get("https://www.facebook.com");

        //Click on Create New Account
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        //fill all the boxes by using keyboard actions
        //fill all the boxes by using keyboard actions
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        actions
                .click(firstNameBox)
                .sendKeys("John")
                .sendKeys(Keys.TAB)
                .sendKeys("Doe")
                .sendKeys(Keys.TAB)
                .sendKeys("johnDoe@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("johnDoe@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("john123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("Feb")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ENTER)
                .perform();


   }


}