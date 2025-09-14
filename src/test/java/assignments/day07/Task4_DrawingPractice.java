package assignments.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task4_DrawingPractice {
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
            driver.quit();
        }


    @Test
    public void drawingPracticeTest() throws InterruptedException {
        // Go to https://claruswaysda.github.io/Draw.html
        driver.get("https://claruswaysda.github.io/Draw.html");

        // Draw a triangle
        WebElement canvas = driver.findElement(By.id("myCanvas"));
        Actions actions = new Actions(driver);

        actions.moveToElement(canvas, 50, 50)
                .clickAndHold()
                .moveByOffset(100, 0)   // first line
                .moveByOffset(-50, 100) // second line
                .moveByOffset(-50, -100)// third line (back to start)
                .release()
                .build().perform();

        Thread.sleep(2000);

        // Reset
        WebElement resetBtn = driver.findElement(By.id("resetButton"));
        resetBtn.click();

        Thread.sleep(2000);
    }
}
