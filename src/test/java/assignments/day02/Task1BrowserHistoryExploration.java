package assignments.day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1BrowserHistoryExploration {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setup:
        // Use @BeforeEach to launch Chrome and maximize.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testBrowserNavigation() {
        // Test 1:
        // Navigate to https://www.wikipedia.org/.
        // Navigate to https://www.google.com/.
        // Navigate back and forward multiple times, asserting the correct title at each step.

        driver.get("https://www.wikipedia.org/");
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.get("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    void testRefreshGoogle() {
        // Test 2:
        // Use driver.navigate().refresh() on Google and assert the title still contains "Google".

        driver.get("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }

    @AfterEach
    void tearDown() {
        // Teardown:
        // Use @AfterEach to close the browser.
        driver.quit();
    }
}
