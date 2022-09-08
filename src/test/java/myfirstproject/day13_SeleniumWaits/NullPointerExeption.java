package myfirstproject.day13_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NullPointerExeption {

    WebDriver driver;
    Faker faker ;
    @Test
    public void nullPointerTest1(){
        driver.get("https//www.google.com");//NullPointerException
//        solution : intantiate the object...WebDriver driver = new ChromeDriver();
    }
    @Test
    public void nullPointerTest2(){
        System.out.println(faker.name().fullName());//NullPointerException
    }

   /*

       Create a class:Synchronization2.
    Create a method: synchronization2
    Go to https://the-internet.herokuapp.com/dynamic_loading/2
    When user clicks on the Start button
    Then verify the ‘Hello World!’ Shows up on the screen


     Create a class:Synchronization3. Create a method: synchronization1
        Go to https://the-internet.herokuapp.com/dynamic_controls
        Click on remove button
        And verify the message is equal to “It's gone!”
        Then click on Add button
        And verify the message is equal to “It's back!”



         Create a class:Synchronization4. Create a method: isEnabled
            Go to https://the-internet.herokuapp.com/dynamic_controls
            Click enable Button
            And verify the message is equal to “It's enabled!”
            And verify the textbox is enabled (I can type in the box)
            And click on Disable button
            And verify the message is equal to “It's disabled!”
            And verify the textbox is disabled (I cannot type in the box)
            NOTE: .isEnabled(); is used to check if an element is enabled or not

*/





}
