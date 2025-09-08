package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Dummy {
    WebDriver driver;


@Test
void myPassingTest(){
    System.out.println("my first test");
    driver.get("https://www.google.com/");
    String actualTitle = driver.getTitle();
    System.out.println("Title: "+ actualTitle);
    Assertions.assertNotEquals("Google", actualTitle);
    driver.quit();
}
/*
@Test
    void myFailingTest(){
        System.out.println("my sacand test");
        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        System.out.println("Title: "+ actualTitle);
        Assertions.assertEquals("Googlex", actualTitle);
        driver.quit();
}*/
    @Test
    void checkAmazon(){
        driver.get("https://www.amazon.com/");
        String actualUrl = driver.getCurrentUrl();
        System.out.println("URL" +actualUrl);
        Assertions.assertTrue(actualUrl.toLowerCase().contains("Amazon".toLowerCase()));
    }

@BeforeEach
    void  beforeEach(){
    System.out.println("beforeEach");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
@BeforeAll
    static void beforeAll(){

    System.out.println("beforeAll");
}
@AfterEach
void  AfterEach(){
 System.out.println("AfterEach");
    driver.quit();
}
@AfterAll
static void AfterAll(){
    System.out.println("AfterAll");

}

}




    //@Test
    //public  void test() {

       // int age =19;
      // System.out.println(age>18);
       // Assertions.assertTrue(age<18);
      //  Assertions.assertFalse(true);


      /*  String name1 = null;
        String name2 = "John";
        String name3 = "John";
        String name4 = new String("John");

        // Check if value is null
        Assertions.assertNull(name1);

        // Check if value is not null
        Assertions.assertNotNull(name2);

        // Compare values (using equals method)
        Assertions.assertEquals(name2, name3);   // same value
        Assertions.assertEquals(name2, name4);   // same value as well

        // Compare references (check if both point to the same object in memory)
        Assertions.assertSame(name2, name3);     // same reference (string pool)

        //Assertions.assertSame(name2, name4);   // this will FAIL, because name4 is a new object */

