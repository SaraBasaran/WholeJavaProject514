package myfirstpackage;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day04_JavaFaker {
    /*
    Test Data: Anything you use to test the app.==> URL, credentials, username, pawds, environment
    Intv. Que==> Where do you get your test data? (They mean credentials==>URL, credentials, username, pawds, environment)
                - Test Lead can provide
                -From Business Analyst==>writes the acceptance criteria==>product owner tells whateer is required for the app.
                 and BA writes the acceptance criteria.
                -Team Lead / Tech Lead
                -Manual Tester==>knows functionality well
                -For changing mock data we use faker.
                **Who knows the app. better he gives the data for the test
                -For API, I use Swagger documentation
                */




    @Test
    public void test1(){
        //1.Create faker object
        Faker faker= new Faker();

        //2.Use faker object to generate mock data
        String firstName= faker.name().firstName();
        System.out.println(firstName); //each run time of the test a new fake name will be generated

        //lastname
        String lastName= faker.name().lastName();
        System.out.println(lastName);

        //username
        String userName= faker.name().username();
        System.out.println(userName);

        //title
        String title= faker.name().title();
        System.out.println(title);

        //city
        String city = faker.address().city();
        System.out.println(city);

        //state
        String state = faker.address().state();
        System.out.println(state);

        //full address
        String fullAddress= faker.address().fullAddress();
        System.out.println(fullAddress);

        //cell phone
        String cellPhone= faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

        //email
        String email= faker.internet().safeEmailAddress();
        System.out.println(email);

        //zip
        String zip= faker.number().digits(5); //num of zip code
        System.out.println(zip);

        //zip
        String zipCode= faker.address().zipCode();
        System.out.println(zipCode);


    }






}
