package myfirstproject.practise;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q02 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        /// 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        //    // 2. Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.id("button1")).click();

        //    // 3. Get the pop-up text
        String alertText=driver.switchTo().alert().getText();

        //    // 4. Verify that message is "I am an alert box!"
        Assert.assertEquals("I am an alert box!", alertText);

        //    // 5. Accept pop-up

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String Url= driver.getCurrentUrl();
        Assert.assertEquals("http://webdriveruniversity.com/Popup-Alerts/index.html", Url);


    }

}
