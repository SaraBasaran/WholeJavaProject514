package myfirstproject.day10_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ExtentReports extends TestBase {

    /*
    This extent test report has 3 main objects==>extentReports, extentHtmlReporter, extentTest.They are used to
     generate custom html report and we use that whenever we need to log some info and generate the report.
     When we configure we can add custom info such "Test Environmet" "App. Name", etc. We can also add document
     info. Then we use extentTest to log the steps, each step "PASS", "FAIL" etc.
     */

    protected static ExtentReports extentReports;  //it is a lib that we use in pom.xml file to create html report. extentreports.com
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentSetUp(){


        //Report Path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Reports/" + currentTime + "html_report.html";

        extentHtmlReporter = new ExtentHtmlReporter(path); //we are going to create html report in this path

        //creating extent reports object for generating the entire report with configuration (you will put some choices)
        extentReports = new ExtentReports();

        //adding custom System Info
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application Name", "TechProEd");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("SQA", "John Fox");

        //we can add more custom info==>We can also add document info.
        extentHtmlReporter.config().setReportName("TechPro Home Page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");

        //now finished configuration.Now we should connect extentReports and extentHtmlReports.
        extentReports.attachReporter(extentHtmlReporter);

        //Report is done now we should create extent test to log info in the test case
        //Creating ExtentTest==>logger
        extentTest=extentReports.createTest("My Extent Reporter", "Regression Test Report");

    }

    @Test
    public void extentReportsTest() {



        //Finished setting up Report info, from now on we can use extentTest object to log info

        extentTest.pass("PASS");
        extentTest.info("INFO");
        extentTest.fail("FAIL");     //==>>these are the report types that we can use
        extentTest.skip("SKIP");
        extentTest.warning("WARNING");

        extentTest.pass("Going to the application URL");
        driver.get("https://www.techproeducation.com");
        extentTest.pass("Opened default page");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA" + Keys.ENTER);//searching qa in search box at homepage
        extentTest.pass("Verifying URL has QA keyword");
        Assert.assertTrue(driver.getCurrentUrl().contains("QA"));

        extentTest.pass("Closing the browser");
        driver.quit();

        //Generating report by using flush().
        extentReports.flush();



    }


}
