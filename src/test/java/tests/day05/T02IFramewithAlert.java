package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class T02IFramewithAlert extends TestBase {

    /*
   Go to https://claruswaysda.github.io/iframe.html
   Type your name in input
   Click on 'Bold' button
   Assert the alert message
   */
    Faker faker = new Faker();

    @Test
    void test() throws InterruptedException {

        // Navigate to the test page
        driver.get("https://claruswaysda.github.io/iframe.html");

        // Switch to the iframe where the input field exists
        driver.switchTo().frame("mce_0_ifr");

        // Generate a random name and type it into the input field
        String name = faker.name().fullName();
        driver.findElement(By.xpath("//input[@placeholder='Type here...']")).sendKeys(name);

        // Switch back to the main page (default content) to access the button
        driver.switchTo().defaultContent();

        // Locate the Bold button by its text
        WebElement button = driver.findElement(By.xpath("//button[.='Bold']"));
        Thread.sleep(2000);

        // Click the Bold button, which triggers an alert
        button.click();

        // Switch to the alert and capture its message
        Alert prompt = driver.switchTo().alert();
        String mass = driver.switchTo().alert().getText();

        // Accept (close) the alert
        prompt.accept();
        Thread.sleep(2000);

        // Verify that the alert message is correct
        Assertions.assertEquals(mass, "Bold button clicked");
    }
}
