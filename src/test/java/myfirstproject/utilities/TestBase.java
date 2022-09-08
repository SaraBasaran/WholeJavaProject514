package myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    /*
    Util package is a kind of support package.Reusable methods,(Before, After)
     */

    protected static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }

    public void takeScreenShot() throws IOException {

        //1.Step:Take ScreeShot
        //1.way:
        File image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//just captures the screenshot does not save it

        String currentTime= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //2.Step: Save screenshot==>we can use target folder in java project part or we can create a new folder in the
        //project level ==> Path of screenshot save folder
        String path= System.getProperty("user.dir")+ "/test-output/Screenshots/"+currentTime+"image.png";
        //=>by using this method selenium will create report folder for screenshots
        FileUtils.copyFile(image, new File(path));



    }



    //IMPORTANT

    //creating a reusable method to scroll into view of an element
    public void scrollIntoViewJS(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    //scroll all the way down of a page
    public void scrollAllDownByJS(){

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    //Scroll all the way up of a page

    public void scrollAllUpByJs(){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    //Click on a specific element. Param: WebElement
    //IMPORTANT
    public void clickByJS(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);

    }

    //Set the value of an input using js executor. Params: WebElement element, String text
    //This method changes the value attribute of an element.
    //It changes the input text
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', '"+text+"')", element);

    }

    //Get the value of an input.Params: idOfElement

    public void getValueByJS(String idOfElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();

        System.out.println(value);


        //How do you get the value of an input box?
        //We can use JS executor.
        //How?
        //I can get the element using js executor and get the value of the element. For example, I can get the element by id,
        // and use value attribute to get the value of in an input. I have to do this because getText() in this case does not
        // return the text in an input==>input value
    }

    //Changes the background color of an element. Params: WebElement element, String color)
    public void changeBackGroundColorByJs(WebElement element, String color){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);

    }

    public void addBorderWithJS(WebElement element, String borderStyle){

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);

    }




}

/* Dependency Notes:
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Properties>
        <Property name="basePath">target/logs</Property>
    </Properties>
    <!--    Appenders : where to show the logs. console, file, ... -->
    <Appenders>
        <!--        formatting fileName for dynamic name generation-->
        <RollingFile name="file"
                     filePattern="${basePath}/TechProEd-%d{HH-mm-ss-SSS}.log">
            <PatternLayout>
                <pattern>%d %p %c{1.} [%t] %m%n</pattern>
            </PatternLayout>
            <!--            creates new file after the size exeeds-->
            <SizeBasedTriggeringPolicy size="500" />
        </RollingFile>
        <Console name="Console" target="SYSTEM_OUT">
            <!--    PatternLayout : what format logs will be displayed -->
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <!--    Loggers : logs the information. Logger is used to override Root level
    additivity="false" avoids duplicated messages that can come from parent levels. This should be used with Logger-->
    <Loggers>
        <Logger name="com.myfirstproject.tests" level="trace" additivity="false">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="file"/>
        </Logger>
        <!--      Root : provides level to ALL classes on the project
        By default level = error prints errors and fatal
        level=trace will logs everything-->
        <Root level="error">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="file"/>
        </Root>
    </Loggers>
</Configuration>
        <!-- https://logging.apache.org/log4j/2.x/manual/customloglevels.html
        Standard Level intLevel
        OFF    0
        FATAL  100
        ERROR  200
        WARN   300
        INFO   400
        DEBUG  500
        TRACE  600
        ALL    Integer.MAX_VALUE
        If i say level="trace", then logs will be anything above trace
        if I say error, then logs will be error and fatal,..
        In summary, this xml is used for configuration of log4j
        There is configuration
        Under configuration, there is Appenders(where to log) and Loggers(Specify the loggers, how, which ones)
        Note that we can customize this logger.
        Add more logger under loggers for custumizing specific package, class,...
        How to write the log messages to a file? Use RollingFile in apperders.
        <RollingFile name="Rolling-${sd:type}" fileName="${filename}"
                              filePattern="target/rolling1/test1-${sd:type}.%i.log.gz">
                   <PatternLayout>
                     <pattern>%d %p %c{1.} [%t] %m%n</pattern>
                   </PatternLayout>
                   <SizeBasedTriggeringPolicy size="500" />
                 </RollingFile>
        -->
            <dependency>
            <groupId>com.google.actions</groupId>
            <artifactId>actions-on-google</artifactId>
            <version>1.8.0</version>
        </dependency>
 */
