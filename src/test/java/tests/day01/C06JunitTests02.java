package tests.day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTests02 {

    /*
// Go to google homepage DO
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
// Print "Tests have finished running" after each test() method
// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"

       Test Scenario: Google homepage tests with JUnit5 and Selenium
       Tasks:
       - Print "Tests are starting to run" before each test() method
       - Print "Tests have finished running" after each test() method
       - Test if the title is the same when the page window is maximized and minimized
       - Test if the title does not contain "Video" when the page window is fullscreen
       - Test if the URL contains "google"
    */

    WebDriver driver;
    String url = "https://www.google.com";

    @Test
    void test01(){
        String titlemaximized;
        String titleminimized;

        driver.manage().window().maximize();
        titlemaximized = driver.getTitle();
        driver.manage().window().minimize();
        titleminimized= driver.getTitle();
        Assertions.assertEquals(titlemaximized,titleminimized,"titles are not equal");
    }
    @Test
    void test02(){
        driver.manage().window().fullscreen();
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));
    }
    @Test
    void test03(){
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("google"));

    }



    @BeforeEach
    void BeforeEach(){
        System.out.println("Test is running");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterEach
    void AfterEach(){
        System.out.println("Test is finished");
        System.out.println();
    }
}
