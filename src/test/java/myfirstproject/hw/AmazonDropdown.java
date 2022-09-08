package myfirstproject.hw;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropdown extends TestBase {

    @Test
    public void dropdownTest() {

        driver.get("https://www.amazon.ca");

        WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));

        //Create select class

        Select select = new Select(dropDownElement);

        String result = select.getFirstSelectedOption().getText();//index starts here "0".

        System.out.println(result);
        Assert.assertEquals("All Departments", result);

        System.out.println(select.getOptions().get(3).getText());
        String result2 = select.getOptions().get(3).getText();
        //Assert.assertEquals("Expected element does not match","Amazon Devices", result2);

        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption : allOptions) {

            System.out.println(eachOption.getText());

        }

        int dropDownSize = allOptions.size();
        System.out.println("Dropdown Size: " + dropDownSize);

        //Assert.assertEquals("Expected Is not Equal To Actual",3, dropDownSize);

        boolean flag = false;
        for (WebElement eachOption : allOptions) {
            //checking if Option 2 is in the dropdown
            //if it is in the dropdown, then flag=true, then assertion will pass
            if (eachOption.getText().contains("Appliances")) {
                flag = true;

            }

        }
        System.out.println(flag);
    }
}

        //
//       List<WebElement> checkList= Collections.sort(allOptions);
//        Collections.sort(checkList); //when you sort==>[10,11,12,15,20]==>if it is required only one min or max no need to sort but for the list "must"
//        System.out.println(checkList);
//






