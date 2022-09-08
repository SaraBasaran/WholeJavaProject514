package myfirstproject.day11_JS;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JSExecutor01 extends TestBase {
    //When user goes to techproeducation homepage and scroll on the "WE OFFER" text and scroll on the search.

    @Test
    public void scrollIntoViewTest() throws InterruptedException {

        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        WebElement weOffer= driver.findElement(By.xpath("//*[.='WE OFFER']"));

        //1.Create JSExecutor object
        JavascriptExecutor js= (JavascriptExecutor)driver;

        //2.Executor JS command
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer); //arguments[0]==>means the first element having weOffer.JS will automatically
                                                                               // scrollInto element
                                                                              // If we have mult. ele.s we can type idx of elements and add weOffer, weOffer..etc

        //Scroll over to Search input that is at the top of the page
        WebElement searchBox= driver.findElement(By.xpath("//input[@type='search']"));
        js.executeScript("arguments[0].scrollIntoView(true);", searchBox);


    }

    @Test
    public void scrollIntoViewTest2() throws InterruptedException {


        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

        WebElement weOffer= driver.findElement(By.xpath("//*[.='WE OFFER']"));

        Thread.sleep(3000);
          scrollIntoViewJS(weOffer); //method comes from TestBase
          Thread.sleep(3000);

          WebElement searchBox= driver.findElement(By.xpath("//input[@type='search']"));
          scrollIntoViewJS(searchBox); //method comes from TestBase
    }

    @Test
    public void scrollAllTheWayDownAndUpTest() throws InterruptedException, IOException {

        driver.get("https://techproeducation.com/");
        Thread.sleep(5000);

        scrollAllDownByJS();
        Thread.sleep(10000);
        takeScreenShot();
        Thread.sleep(5000);
        takeScreenShot();
        scrollAllUpByJs();
        Thread.sleep(10000);
        takeScreenShot();


    }

    @Test
    public void clickByJSTests(){
        driver.get("https://techproeducation.com/");

        WebElement lmsLogin=driver.findElement(By.linkText("LMS Login"));
        clickByJS(lmsLogin);

    }

    @Test
    public void setValueByJSTest(){

        driver.get("https://techproeducation.com");
        WebElement searchBox= driver.findElement(By.xpath("//input[@type='search']"));
        setValueByJS(searchBox, "QA");

    }

    @Test
    public void getValueByJSTest(){

        driver.get("https://carettahotel.com");
        WebElement checkIn= driver.findElement(By.id("checkin_date"));
       // System.out.println(checkIn.getText());
        // ==>returns empty bec. there is no data in that check in element.We cannot get text from an input by using getText().
        getValueByJS("checkin_date"); //returns the value of an element whose id= checkin_date ==>9/3/2022

    }

    @Test
    public void changeBackGroundColorJSTest(){
        driver.get("https://carettahotel.com");
         WebElement checkAvailability= driver.findElement(By.xpath("//input[@type='submit']"));
         changeBackGroundColorByJs(checkAvailability, "red");

        WebElement loginButton= driver.findElement(By.xpath("//a[.='Log in']"));
        addBorderWithJS( loginButton, "5px solid yellow");
    }




}
