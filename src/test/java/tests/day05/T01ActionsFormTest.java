package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

public class T01ActionsFormTest extends TestBase {
    Faker faker = new Faker();

    /*
      Go to https://claruswaysda.github.io/ActionsForm.html
      Fill the form
      Generate Passcode
      Use passcode to submit form
     */

    By name = By.id("name");
    By age = By.id("age");
    By chosse = By.xpath("//label[normalize-space()='Coding']");
    By choose2 = By.xpath("//label[normalize-space()='Design']");
    By choose3 = By.xpath("//label[normalize-space()='Management']");
    By genderm = By.xpath("//input[@value='male']");
    By genderf = By.xpath("//input[@value='female']");
    By gendero = By.xpath("//input[@value='other']");

    @Test
    void testZahra() throws InterruptedException {
        // Navigate to the form page
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        // Fill in name and age
        driver.findElement(name).sendKeys("zahra");
        driver.findElement(age).sendKeys("20");

        // Select "it" from dropdown
        Select select = new Select(driver.findElement(By.xpath("//select[@id='options']")));
        select.selectByValue("it");

        // Select checkboxes and gender
        driver.findElement(choose3).click();
        driver.findElement(chosse).click();
        driver.findElement(genderf).click();

        // Click on generate passcode button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        // Get the text from the first alert
        String alert = driver.switchTo().alert().getText();
        System.out.println("password: " + alert);

        // Extract only the passcode number from the alert text
        String Pass = alert.substring(alert.indexOf(":") + 1).trim();
        System.out.println("Extracted password = " + Pass);

        // Accept the first alert (info alert)
        driver.switchTo().alert().accept();

        // Handle the second alert (prompt), enter the passcode, and accept
        driver.switchTo().alert().sendKeys(Pass);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Switch to iframe and click on submit button
        driver.switchTo().frame("iframeSubmit");
        WebElement sub = driver.findElement(By.id("submitButton"));
        sub.click();
        Thread.sleep(2000);
    }
}
