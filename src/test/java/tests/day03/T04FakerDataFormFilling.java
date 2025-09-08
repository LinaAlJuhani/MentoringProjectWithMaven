package tests.day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {

    WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void fakerTest() {
        driver.get(url);
        Faker faker = new Faker();

        // Generate fake data
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();

        // Fill form
        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

        // --- Fix: Use JavaScript click instead of normal click ---
        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        // Locate output elements
        WebElement outputName = driver.findElement(By.id("name"));
        WebElement outputEmail = driver.findElement(By.id("email"));
        WebElement outputCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement outputPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        // Assertions
        Assertions.assertTrue(outputName.getText().contains(fullName));
        Assertions.assertTrue(outputEmail.getText().contains(email));
        Assertions.assertTrue(outputCurrentAddress.getText().contains(currentAddress));
        Assertions.assertTrue(outputPermanentAddress.getText().contains(permanentAddress));
    }
}
