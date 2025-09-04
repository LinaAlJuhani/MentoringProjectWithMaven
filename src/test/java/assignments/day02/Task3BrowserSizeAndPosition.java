package assignments.day02;


import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3BrowserSizeAndPosition {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setup:
        // Open Chrome in @BeforeEach.
        driver = new ChromeDriver();
    }

    @Test
    void testSetBrowserSize() {
        // Test 1:
        // Navigate to https://www.bbc.com/.
        // Set browser size to 800x600 and assert the window size.

        driver.get("https://www.bbc.com/");
        driver.manage().window().setSize(new Dimension(800, 600));

        Dimension size = driver.manage().window().getSize();
        System.out.println("Width: " + size.getWidth() + ", Height: " + size.getHeight());

        Assertions.assertEquals(800, size.getWidth());
        Assertions.assertEquals(600, size.getHeight());
    }

    @Test
    void testSetBrowserPosition() {
        // Test 2:
        // Move the window to position (100, 100) and assert its position.

        driver.manage().window().setPosition(new Point(100, 100));

        Point position = driver.manage().window().getPosition();
        System.out.println("X: " + position.getX() + ", Y: " + position.getY());

        Assertions.assertEquals(100, position.getX());
        Assertions.assertEquals(100, position.getY());
    }

    @AfterEach
    void tearDown() {
        // Teardown:
        // Close the browser.
        driver.quit();
    }
}

