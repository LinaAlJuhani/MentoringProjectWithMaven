package tests.day04;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02CheckboxInteraction {

    /*
     Task 2: Checkbox Interaction
 Question: Go to "
 https://the-internet.herokuapp.com/checkboxes". Write a method that:
 Checks the current state of both checkboxes
 Ensures both checkboxes are selected (click only if not already selected)
 Verify both checkboxes are checked after the operations
 Print the status of each checkbox to console */

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
 @Test
 void Checkbox() throws InterruptedException{
     driver.get("https://the-internet.herokuapp.com/checkboxes");

    // Checks the current state of both checkboxes
     WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
     WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

     Thread.sleep(2000);


     // 3. Ensure both are selected
     if (!checkbox1.isSelected()) {
         checkbox1.click();
     }
     Thread.sleep(2000);

     if (!checkbox2.isSelected()) {
         checkbox2.click();
     }
     Thread.sleep(2000);

     // Verify
     Assertions.assertTrue(checkbox1.isSelected(), " Checkbox 1 is NOT selected");
     Assertions.assertTrue(checkbox2.isSelected(), " Checkbox 2 is NOT selected");


     System.out.println(" Checkbox 1 is selected: " + checkbox1.isSelected());
     System.out.println(" Checkbox 2 is selected: " + checkbox2.isSelected());
     }








}
