package assignments.day07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_WindowHandle {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /*
    Go to https://claruswaysda.github.io/
    Click on Window Handle
    Click on 'Open Index Page'
    Verify the link 'https://claruswaysda.github.io/index.html'
    */
    @Test
    public void windowHandleTest() {
        // Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

        // Click on Window Handle
        driver.findElement(By.linkText("Window Handle")).click();

        // Store the main window handle
        String mainWindow = driver.getWindowHandle();

        // Click on 'Open Index Page'
        driver.findElement(By.linkText("Open Index Page")).click();

        // Get all windows and switch to the child
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }

        // Verify the link 'https://claruswaysda.github.io/index.html'
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://claruswaysda.github.io/index.html", currentUrl);
    }
}
