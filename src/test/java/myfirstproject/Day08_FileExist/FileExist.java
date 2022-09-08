package myfirstproject.Day08_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist {

    @Test
    public void isExistTest(){

        //Pick a file on your Desktop
        String homeDirectory= System.getProperty("user.home");
        //System.out.println(homeDirectory);
        //String userDirectory= System.getProperty("user.dir");
        //System.out.println(userDirectory);
        //Verify if that file exist on your computer or not
        //Users\BEKİR==>homedirectory

        String filePath= "C:\\Users\\BEKİR\\Desktop\\techpro files\\TechProEd Picture-4.jpeg";

        boolean isExist= Files.exists(Paths.get(filePath));

        Assert.assertTrue(isExist);
       // "C:\Users\BEKİR\Desktop\techpro files\TechProEd Picture-4.jpeg"

    }
    @Test
    public void isExist1(){
        //Pick a file on your Desktop
        String homeDirectory= System.getProperty("user.home");
        System.out.println(homeDirectory);
        String userDirectory= System.getProperty("user.dir");
        System.out.println(userDirectory);
        String filePath= homeDirectory+ "\\Desktop\\techpro files\\TechProEd Picture-4.jpeg";
        //if we delete home directory part we can make a dynamic code

        boolean isExist= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist); //this utility comes from java... not selenium





    }



}
