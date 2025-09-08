package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class T01ChromeOptionsConfigurationTest {
    /*
    Task: Create a test method that opens LinkedIn with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars
    Navigate to "https://www.linkedin.com/login" and verify the title contains "LinkedIn"
     */
    WebDriver driver;
    String url = "https://www.linkedin.com/login";

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");     // maximize window
        options.addArguments("--disable-extensions");  // disable extensions
        options.addArguments("--disable-infobars");    // disable infobars
        options.addArguments("--incognito");           // incognito mode

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void testLinkedInLoginPage() {
        // Navigate to LinkedIn
        driver.get(url);

        // Verify that the page title contains "LinkedIn"
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assertions.assertTrue(title.contains("LinkedIn"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
