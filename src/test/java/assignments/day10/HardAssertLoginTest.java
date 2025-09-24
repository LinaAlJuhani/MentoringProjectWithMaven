package assignments.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HardAssertLoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // @BeforeClass - Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void positiveLoginTest() {
        // Positive Login Test
        driver.get("https://claruswaysda.github.io/signIn.html");

        // Step 1: Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        // Step 2: Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");

        // Step 3: Click Submit button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Debug: print url current
        System.out.println("current URL: " + driver.getCurrentUrl());

        // Debug: print all page
        System.out.println(driver.getPageSource());

        // Step 4: Assert page URL
        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL verification failed!");

        // Step 5: Assert page contains text "Employee Table"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tableHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Employee Table')]"))
        );

        Assert.assertTrue(tableHeader.getText().contains("Employee Table"), "Employee Table text not found!");
    }

}
