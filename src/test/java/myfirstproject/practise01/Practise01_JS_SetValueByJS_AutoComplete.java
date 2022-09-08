package myfirstproject.practise01;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Practise01_JS_SetValueByJS_AutoComplete extends TestBase {

    @Test
    public void setValueByJavaScript(){
        /*
        When user goes to https://www.queryui.com/autocomplete
        Then type Apple
        And select AppleScript
         */


        driver.get("https://www.jqueryui.com/autocomplete");
        driver.switchTo().frame(0);
        WebElement inputBox= driver.findElement(By.id("tags"));
        inputBox.sendKeys("Apple");

        //ui-menu-item WILL ONLY BE AVAILABLE AFTER USER TYPE IN THE INPUT
        //TESTER SHOULD MAKE A GOOD MANUAL TESTING TO GET OBSERVATION OF BEHAVIOUR TO LOCATE THE ELEMENT
        WebElement suggestion= driver.findElement(By.className("ui-menu-item"));
//        suggestion.click();
//
        //or alternatively we can use click with js
        clickByJS(suggestion);

        //İF WE WANT TO GET ALL SUGGESTION LISTED IN INPUT ELEMENT
        List<WebElement> suggestionList =driver.findElements(By.className("ui-menu-item"));

        for(WebElement eachElement: suggestionList){

            System.out.println(eachElement.getText());
            if(eachElement.getText().equals("Java")){
                eachElement.click();
                break;
            }
        }
        System.out.println(suggestionList);
             /*
             Homework 1:
             When user goes to https://www.jqueryui.com
             Then user clicks on Section 2 accordion
             And verify the test contains "Sed non urna."

             HomeWork 2:
             When user goes to https://www.jqueryui.com/toggle
             Then select the next date of the current date
             Verify the date is the next day of today

             HomeWork 3:
                          When user goes to https://www.jqueryui.com/toggle
                          Print the text : "Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
                          Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi."
                          Then, click on run Effect Button
                          Then, print the text and verify it is empty
                          Then, click on run Effect Button once more
                          Then, print the text and verify it is empty
                          **You can add hardwaits if needed.





              */


    }



}
