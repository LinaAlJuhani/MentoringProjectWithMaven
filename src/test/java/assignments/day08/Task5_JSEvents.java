package assignments.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Task5_JSEvents {

    static WebDriver driver;
    static Actions actions;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    void testAllEvents() {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        // 1. onclick
        driver.findElement(By.id("onclick")).click();

        // 2. oncontextmenu (right click)
        WebElement rightClickBtn = driver.findElement(By.id("oncontextmenu"));
        actions.contextClick(rightClickBtn).perform();

        // 3. ondblclick
        WebElement doubleClickBtn = driver.findElement(By.id("ondoubleclick"));
        actions.doubleClick(doubleClickBtn).perform();

        // 4. onfocus
        driver.findElement(By.id("onfocus")).click();

        // 5. onkeydown
        WebElement keydown = driver.findElement(By.id("onkeydown"));
        keydown.sendKeys(Keys.ENTER);

        // 6. onkeypress
        WebElement keypress = driver.findElement(By.id("onkeypress"));
        keypress.sendKeys("a");

        // 7. onkeyup
        WebElement keyup = driver.findElement(By.id("onkeyup"));
        keyup.sendKeys("b");

        // 8. onmouseover
        WebElement mouseover = driver.findElement(By.id("onmouseover"));
        actions.moveToElement(mouseover).perform();

        // 9. onmouseleave
        WebElement mouseleave = driver.findElement(By.id("onmouseleave"));
        actions.moveToElement(mouseleave).perform();
        actions.moveByOffset(100, 0).perform(); // move away to trigger mouseleave

        // 10. onmousedown
        WebElement mousedown = driver.findElement(By.id("onmousedown"));
        actions.clickAndHold(mousedown).release().perform();
    }

    @AfterAll
    static void tearDown() {

            driver.quit();
        }
}
