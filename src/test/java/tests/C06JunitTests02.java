package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTests02 {

    /*
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

    @BeforeEach
    void setUp() {
        // Runs before each test
        System.out.println("Tests are starting to run");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        // Runs after each test
        System.out.println("Tests have finished running");
        driver.quit();
    }

    @Test
    void titleSameWhenMaximizedAndMinimized() {
        String titleMaximized;
        String titleMinimized;

        driver.manage().window().maximize();
        titleMaximized = driver.getTitle();
        System.out.println("Title (maximized) = " + titleMaximized);

        driver.manage().window().minimize();
        titleMinimized = driver.getTitle();
        System.out.println("Title (minimized) = " + titleMinimized);

        // Check if titles are the same
        Assertions.assertEquals(titleMaximized, titleMinimized, "Titles are not the same");
    }

    @Test
    void titleDoesNotContainVideoWhenFullscreen() {
        driver.manage().window().fullscreen();

        String title = driver.getTitle();
        System.out.println("Title (fullscreen) = " + title);

        // Check that title does not contain "Video"
        Assertions.assertFalse(title.contains("Video"), "Title contains 'Video'");
    }

    @Test
    void urlContainsGoogle() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentUrl);

        // Check if the URL contains "google"
        Assertions.assertTrue(currentUrl.contains("google"), "URL does not contain 'google'");
    }
}
