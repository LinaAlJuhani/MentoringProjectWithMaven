package assignments.day08;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
/*
 * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
 * Click into the username field.
 * Type the username using sendKeys.
 * Use the Robot class to:
 * Press Tab → go to password field.
 * Type the password using sendKeys.
 * Press Enter → submit the form.
 * Verify login success or error message.
 */
public class Task4_RobotClassLogin {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void loginWithRobot() throws AWTException {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("tomsmith");

        Robot robot = new Robot();

        // Tab → to move to password field
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        WebElement password = driver.switchTo().activeElement();
        password.sendKeys("SuperSecretPassword!");

        // Press Enter → to submit form
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement flashMessage = driver.findElement(By.id("flash"));
        Assertions.assertTrue(flashMessage.getText().contains("You logged into a secure area!")
                || flashMessage.getText().contains("Your username is invalid!"));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) driver.quit();
    }
}

