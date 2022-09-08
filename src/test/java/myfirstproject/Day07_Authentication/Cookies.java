package myfirstproject.Day07_Authentication;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies extends TestBase {

    /*
            -Go to amazon and automate the tasks:
        1. Find the total number of cookies
        2. Print all the cookies
        3. Get the cookies by their name
        4. Add new cookie
        5. Delete cookie by name
        6. Delete all of the cookies
     */

    @Test
    public void cookieTest(){

        //Go to amazon
        driver.get("https://amazon.com/ca");

        //1.Find the total number of cookies
        Set<Cookie> allCookies= driver.manage().getCookies();
       int cookieSize= allCookies.size();
        System.out.println("Original Cookie Size = " + cookieSize);

        //Print all the cookies
     for (Cookie w: allCookies){
         System.out.println("Cookie: "+w);

     }

        for (Cookie w: allCookies){

            System.out.println("Cookie name: " + w.getName());
        }

        //3.Get the cookies by their name
        Cookie namedCookie= driver.manage().getCookieNamed("ubid-name");
        System.out.println("ubid-named Cookie: " + namedCookie);

     //4.Add new cookie
     Cookie myCookie= new Cookie("My-Fav-Cookie", "Kavala");
     driver.manage().addCookie(myCookie);
        System.out.println(cookieSize);

        Set<Cookie> newCookies= driver.manage().getCookies();
        System.out.println("After adding cookies size: " + newCookies.size());

     //5.Delete cookie by name
     driver.manage().deleteCookieNamed("sp-cdn");
        System.out.println("After deleting cookie, the cookie size: "+ driver.manage().getCookies().size());

     //6.delete all cookies
     driver.manage().deleteAllCookies();
        System.out.println("After deleting all cookies size is: " + driver.manage().getCookies().size());

        driver.quit();











    }




}
