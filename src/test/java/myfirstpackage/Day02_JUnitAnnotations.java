package myfirstpackage;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /* All test methods have to be "void" bec. we do not want to create or return diff. data in testing
     we just want to create test cases by using @Test==>test annotation.We cannot run methods without @Test.
    @BeforeClass is used to run once before the entire class.It is also used for Pre-conditions==>has to be static bec. it is a common method
    @AfterClass is used to run once after the entire class. It is also used for after-conditions===>like quit()
     takeScreenShot().
     */
    @BeforeClass  //wherever you type this before all class methods are executed
    public static void setUpClass(){

        System.out.println("Before Class ==>@BeforeClass");


    }
    @AfterClass
    public static void Method(){

        System.out.println("After Class==>@AfterClass");

    }


    @Before
    public void BeforeMethod() {

        System.out.println("@Before Method");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");

    }
    @Test
    public void test2(){
        System.out.println("Test 2");

    }
    @After
    public void AfterMethod(){
        System.out.println("@After Method");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");

    }
    @Test
    public void test4(){

        System.out.println("Test 4");

    }











}
