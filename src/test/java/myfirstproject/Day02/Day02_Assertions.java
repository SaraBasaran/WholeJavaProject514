package myfirstproject.Day02;

import org.junit.Assert;
import org.junit.Test;

public class Day02_Assertions {

    /*
    Assertion is done to check if expected data equals to actual data.
    Green check mark means the test passes.
    Yellow cross sign like X means test fails.

    Assert.assertFalse(false); ==> it will pass
    Assert.assertFalse(true); ==> it will fail

    Assert.assertTrue(true); ==> it will pass
    Assert.assertTrue(false); ==> it will fail

     */

    @Test
    public void assertions() {

        Assert.assertEquals(2, 2);
        Assert.assertEquals("John", "John");
        Assert.assertEquals(true, true);
        Assert.assertEquals(3, 2 + 1);

        Assert.assertTrue(true);
        Assert.assertFalse("John".contains("O")); //as the result is false for the condition the test does not fail

        if ("John".equals("john")) {

            //Verification:if the statement fails, test case will continue to execute
        }

        Assert.assertTrue("Ali".contains("A"));
        Assert.assertFalse("Ayse".equals("ayse"));


    }
}