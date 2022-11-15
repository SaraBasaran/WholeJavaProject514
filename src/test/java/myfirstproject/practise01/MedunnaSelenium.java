package myfirstproject.practise01;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MedunnaSelenium extends TestBase {

    @Test
    public void userGetshomePage(){

        driver.get("https://medunna.com");

      //  driver.findElement(By.xpath("//a[@class='d-flex align-items-center dropdown-toggle nav-link']")).click();

        WebElement signInDropDown= driver.findElement(By.xpath("//a[@class='d-flex align-items-center dropdown-toggle nav-link']"));
        Select select= new Select(signInDropDown);
        select.selectByVisibleText("Sign in");


    }





}
