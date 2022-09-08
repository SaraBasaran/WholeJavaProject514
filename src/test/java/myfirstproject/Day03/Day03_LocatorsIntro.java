package myfirstproject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

    /*
    How many locators are there?
    8.
    Id, Name, className, tagName, linkText, partialLinkText, xpath, cssSelecter
    **findElement(By.Id("id value")); ==>returns a WebElement==>comes from selenium
    **findElements();==>when we expect to get multiple elements.List<WebElement>
    >

    The test case:
    user goes to http://a.testaddressbook.com/sign_in
    Locate the elements of email textbox, password textbox, and signin button
    Enter below username and password then click sign in button
    Username : testtechproed@gmail.com
    Password : Test1234!
    Then verify that the expected user id testtechproed@gmail.com (USE getText() method to
            get the text from the page)
    Verify the Addresses and Sign Out texts are displayed
    Find the number of total link on the page
    Sign out from the page

     */

    public class Day03_LocatorsIntro {

//    user goes to http://a.testaddressbook.com/sign_in
//    Locate the elements of email textbox, password textbox, and signin button
//    Enter below username and password then click sign in button
//    Username : testtechproed@gmail.com
//    Password : Test1234!
//    Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
//    Verify the Addresses and Sign Out texts are displayed
//    Find the number of total link on the page
//    Print all link names
//    Sign out from the page

        WebDriver driver;

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        }

        @After
        public void tearDown(){
            driver.quit();
        }

        @Test
        public void login(){


//      user goes to http://a.testaddressbook.com/sign_in
            driver.get("http://a.testaddressbook.com/sign_in");

//      Locate the elements of email textbox, password textbox, and signin button
            driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

            WebElement passwordBox = driver.findElement(By.id("session_password"));
            passwordBox.sendKeys("Test1234!");

            WebElement signInButton = driver.findElement(By.name("commit"));
            signInButton.click();

//      Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
            String actualEmail = driver.findElement(By.className("navbar-text")).getText();//after putting getText()
                                                                                          //it should be in a String container
            String expectedEmail = "testtechproed@gmail.com";
            Assert.assertEquals(expectedEmail,actualEmail);

//      Verify the Addresses and Sign Out texts are displayed
          //  getText() is used to get the text of a webelement. It returns a String.

            WebElement addressElement = driver.findElement(By.linkText("Addresses"));//when we check the psge source as there is no id, no name,
                                                                                    // no unique className, no unique tag name, we have to use linkText()
            Assert.assertTrue(addressElement.isDisplayed());                        //<a ==> this tag means that it has a link. To get the text of the link
                                                                                   //we use linkText() or partialLinkText().

            //There is a rule in selenium if there are multiple matches, selenium will return the first one from the code source. If we want to get
            // both of the elements, we should use driver.findElements()
            WebElement signOutElement = driver.findElement(By.linkText("Sign out"));

            //isDisplayed() is used to check if an element is on the page or not. It returns a boolean value.
            Assert.assertTrue(signOutElement.isDisplayed());

//      Find the number of total link on the page
//      a tag is used to create links
            List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));//this will return all links
            System.out.println("listOfLinksSize = " + listOfLinks.size());

//      Print all link names
            for(WebElement w : listOfLinks){

                System.out.println(w.getText());
            }

//     Sign out from the page
            driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();

            //     We are able to click on signout button
            //     We need to assert the sign out functionality works
            //     We can locate a core element for assertion
            //     Or we can use URL for assertion
            //     Sign out URL :http://a.testaddressbook.com/
            //     Assert that after clicking signout, the URL shoud be http://a.testaddressbook.com/sign_in

            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.equals("http://a.testaddressbook.com/sign_in"));



        }
    }




