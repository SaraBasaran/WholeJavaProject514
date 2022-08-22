package practise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    //  ...Exercise2...
    // Create a new class under Q02
    // Set Path
    // Create chrome driver
    // Maximize the window
    // Open google home page https://www.google.com/
    // Wait for 3 seconds
    // Go to the "https://www.amazon.com"
    // Get the title and URL of the page
    // Check if the title contains the word "Smile" print console "Title contains Smile" or "Title does not contain Smile"
    // Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
    // Then go to "https://techproeducation.com/"
    // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
    // Back to the previous webpage, https://www.amazon.com"
    // Refresh the page
    // Navigate to techproeducation.com
    // Wait for 3 seconds
    // Close the browser
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Go to the "https://www.amazon.com"
        driver.navigate().to("https://www.amazon.com");

        // Get the title and URL of the page
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);
        String amazonURL = driver.getCurrentUrl();
        System.out.println("amazonURL = " + amazonURL);

        // Check if the title contains the word "Smile" print console "Title contains Smile" or "Title does not contain Smile"
        if(amazonTitle.contains("Smile")){
            System.out.println("Title contains Smile");
        }else {
            System.out.println("Title does not contain Smile");
        }

        // Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
        if(amazonURL.contains("auto")){
            System.out.println("URL contains auto" );
        }else {
            System.out.println("URL does not contain auto");
        }

        // Then go to "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");

        // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
        String techProTitle = driver.getTitle();
        System.out.println("techProTitle = " + techProTitle);

        if(techProTitle.contains("site")){
            System.out.println("Title contains site" );
        }else {
            System.out.println("Title does not contain site");
        }

        // Back to the previous webpage, https://www.amazon.com"
        driver.navigate().back();

        // Refresh the page
        driver.navigate().refresh();

        // Navigate to techproeducation.com
        driver.navigate().forward();

    }
    @After
    public void tearDown() throws InterruptedException {
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Close the browser
        driver.quit();
    }

}