package assignments.day07;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3_DragAndDropPractice {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /*
     Go to https://claruswaysda.github.io/dragAndDrop.html
     Drag the items in their right places
     Assert the success message
    */
    @Test
    public void dragAndDropPracticeTest() {
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        // Locate pieces
        WebElement piece1 = driver.findElement(By.id("piece1"));
        WebElement piece2 = driver.findElement(By.id("piece2"));
        WebElement piece3 = driver.findElement(By.id("piece3"));

        // Locate slots
        WebElement slot1 = driver.findElement(By.id("slot1"));
        WebElement slot2 = driver.findElement(By.id("slot2"));
        WebElement slot3 = driver.findElement(By.id("slot3"));

        // Drag and drop each piece to its slot
        actions.dragAndDrop(piece1, slot1).perform();
        actions.dragAndDrop(piece2, slot2).perform();
        actions.dragAndDrop(piece3, slot3).perform();

        // Assert success message
        WebElement successMsg = driver.findElement(By.id("celebrate"));
        assertTrue(successMsg.isDisplayed(), "Success message should be displayed!");
        assertTrue(successMsg.getText().contains("Congratulations"), "Message should contain 'Congratulations'");
    }
}
