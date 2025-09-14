package assignments.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Task2_ActionsClass {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Actions + Explicit Wait
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    //====================== DOUBLE CLICK TEST ======================
    @Test
    public void doubleClickTest() {
        driver.get("https://claruswaysda.github.io/doubleclick.html");

        // Locate the button
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doubleClickBtn")));

        // Perform double click
        actions.doubleClick(button).perform();

        // Verify button text changed
        assertTrue(button.getText().contains("Double Clicked!"));
    }

    //====================== RIGHT CLICK TEST ======================
    @Test
    public void rightClickTest() {
        driver.get("https://claruswaysda.github.io/actionsClickDrag.html");


        // Locate the box
        WebElement box = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hot-spot")));

        // Right click
        actions.contextClick(box).perform();

        // Handle alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        // Verify alert text
        assertEquals("You selected a context menu", alertText);

        // Close alert
        alert.accept();
    }

    //====================== HOVER + DRAG&DROP TEST ======================
    @Test
    public void hoverAndDragDropTest() {
        driver.get("https://claruswaysda.github.io/actionsClickDrag.html");

        // Hover over the first image
        WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img)[1]")));
        actions.moveToElement(img).perform();

        // Verify caption shows up
        WebElement caption = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("figcaption")));
        assertTrue(caption.isDisplayed());

        // Drag & Drop
        WebElement drag = driver.findElement(By.id("drag1"));
        WebElement drop = driver.findElement(By.id("div1"));
        actions.dragAndDrop(drag, drop).perform();

        // Verify drag and drop worked
        String dropText = drop.getText();
        assertTrue(dropText.contains("Drag me"));
    }
}
