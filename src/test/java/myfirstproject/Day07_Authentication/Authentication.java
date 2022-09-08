package myfirstproject.Day07_Authentication;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Authentication extends TestBase {

    @Test
    public void test(){

        //username:admin
        //pwd: admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Verify the login mesg.
        String successMessage= driver.findElement(By.xpath("//p")).getText();

        Assert.assertTrue(successMessage.contains("Congratulations"));



    }












}
