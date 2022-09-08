package myfirstproject.Day08_FileExist;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Actions03 extends TestBase {
    @Test
    public void pageUpDownTest() throws InterruptedException {

        driver.get("https://techproeducation.com");
        Actions actions= new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //We can chain multiple actions methods. Then we should use build().perform().
         // .build() helps when there are multiple commands on the same line==>like conducting to synchronization
        //.perform() is used when there is single or multiple commands on the same actions
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
         //sendkeys()==> is used for both sending values and also keyboard actions for the app. testing

        //ARROW_DOWN

        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();



    }








}
