package tests.day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathComparisonTest {
    WebDriver driver;
    // Navigate to: https://opensource-demo.orangehrmlive.com/
    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input";

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']";

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    String relativePasswordXPath = "//input[@name='password']";

    // TODO: Locate login button using both methods
    String absoluteLoginBtnXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button";
    String relativeLoginBtnXPath = "//button[@type='submit']";

    // TODO: Test both approaches work
    @Test
    void relativeXpathTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // beginner: implicit wait
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.xpath(relativeUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(relativePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(relativeLoginBtnXPath)).click();

        driver.quit();
    }

    @Test
    void absoltuXpathTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // beginner: implicit wait
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.xpath(absoluteUsernameXPath)).sendKeys("Admin");
        driver.findElement(By.xpath(absolutePasswordXPath)).sendKeys("admin123");
        driver.findElement(By.xpath(absoluteLoginBtnXPath)).click();

        driver.quit();
    }
}

