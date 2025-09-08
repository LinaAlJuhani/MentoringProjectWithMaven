package assignments.day03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02SecondAssingment {
    String url = "https://testpages.herokuapp.com/styled/index.html";

    @Test
    void testNavigationAndInput() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO: Navigate to test pages
        driver.get(url);

        // TODO: Click on "Locators - Find By Playground Test Page"
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();

        // TODO: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // TODO: Navigate back
        driver.navigate().back();

        // TODO: Print URL after going back
        System.out.println("URL after going back: " + driver.getCurrentUrl());

        // TODO: Click on "WebDriver Example Page"
        driver.findElement(By.linkText("WebDriver Example Page")).click();

        // TODO: Print current URL
        System.out.println("Current URL (WebDriver page): " + driver.getCurrentUrl());

        // TODO: Enter value 20 in number input
        WebElement numberInput = driver.findElement(By.id("numentry"));
        numberInput.clear();
        numberInput.sendKeys("20");
        driver.findElement(By.id("submit-to-server")).click();

        // TODO: Verify 'two, zero' message appears
        WebElement result = driver.findElement(By.id("message"));
        String message = result.getText();
        System.out.println("Result Message: " + message);
        assertTrue(message.contains("two, zero"));

        driver.quit();
    }
}
