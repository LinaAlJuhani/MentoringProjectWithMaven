package assignments.day02;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4MultipleNavigationAndVerification {

    static WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setup:
        // Launch Chrome and maximize in @BeforeEach.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testMultipleNavigationTitles() {
        // Test 1:
        // Navigate Google → YouTube → LinkedIn.
        // Assert titles contain "Google", "YouTube", "LinkedIn" respectively.

        driver.get("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.get("https://www.youtube.com/");
        Assertions.assertTrue(driver.getTitle().contains("YouTube"));

        driver.get("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
    }

    @Test
    void testBackAndForwardNavigation() {
        // Test 2:
        // Navigate back twice and assert the URL of Google.
        // Navigate forward twice and assert URL of LinkedIn.

        driver.get("https://www.google.com/");
        driver.get("https://www.youtube.com/");
        driver.get("https://www.linkedin.com/");

        driver.navigate().back();  // back to YouTube
        driver.navigate().back();  // back to Google
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"));

        driver.navigate().forward();  // forward to YouTube
        driver.navigate().forward();  // forward to LinkedIn
        Assertions.assertTrue(driver.getCurrentUrl().contains("linkedin"));
    }

    @AfterAll
    static void tearDown() {
        // Teardown:
        // Use @AfterAll to quit the browser.
        driver.quit();
    }
}
