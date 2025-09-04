package assignments.day02;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2PageSourceValidation {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setup:
        // Use @BeforeEach to open Chrome and maximize.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testSeleniumPageSource() {
        // Test 1:
        // Navigate to https://www.selenium.dev/.
        // Verify that the page source contains the word "WebDriver".

        driver.get("https://www.selenium.dev/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("WebDriver"));
    }

    @Test
    void testPythonPageSource() {
        // Test 2:
        // Navigate to https://www.python.org/.
        // Assert the page source contains "Python".

        driver.get("https://www.python.org/");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Python"));
    }

    @AfterEach
    void tearDown() {
        // Teardown:
        // Close the browser with @AfterEach.
        driver.quit();
    }
}
