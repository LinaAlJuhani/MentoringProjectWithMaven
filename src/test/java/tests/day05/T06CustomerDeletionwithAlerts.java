package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utilities.TestBase;

import java.time.Duration;

public class T06CustomerDeletionwithAlerts extends TestBase {

    /*
    Go to URL: http://demo.guru99.com/test/delete_customer.php
    Delete customer ID: 123
    Handle 2 alerts that appear
    */
    @Test
    void test() {
        // Navigate to the page
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        // Enter customer ID and click submit button
        driver.findElement(By.name("cusid")).sendKeys("123");
        driver.findElement(By.name("submit")).click();

        // Wait until the first alert is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        // Handle the first alert (confirmation alert)
        // Expected message: "Do you really want to delete this Customer?"
        String alert1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assertions.assertTrue(alert1.contains("Do you really want to delete this Customer?"));

        // Handle the second alert (result alert)
        // Expected message: "Customer Successfully Delete!"
        String alert2 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assertions.assertTrue(alert2.contains("Customer Successfully Delete!"));
    }
}
