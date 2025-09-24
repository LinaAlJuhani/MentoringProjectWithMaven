package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class T03RadioButtonSelection {

    /*
     Task 3: Radio Button Selection
 Question: Navigate to "
 https://demoqa.com/radio-button". Create a test that:
 Attempts to select each radio button (Yes, Impressive, No)
 Prints whether each option is enabled/disabled
 For enabled options, select them and verify selection
 Print confirmation message for each successful selection
     */
    WebDriver driver;

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);  // هنا بدون WebDriver
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
       Thread.sleep(2000);
       driver.quit();
   }
/*
   @Test

    void Radio() {

       driver.get("https://demoqa.com/radio-button");

       By yesRadioButton = By.xpath("//p/input");
       By impressiveRadioButton = By.xpath("(//p/input)[2]");
       By noRadioButton = By.xpath("(//p/input)[3]");
       List<WebElement> checkBoxes = driver.findElements(yesRadioButton);

       for (WebElement checkBox:checkBoxes){
           checkBox.click();
           Assertions.assertTrue(checkBox.isSelected());
       }


       driver.findElement(yesRadioButton).click();
       System.out.println(driver.findElement(yesRadioButton).isSelected());
       System.out.println(driver.findElement(impressiveRadioButton).isSelected());
       System.out.println(driver.findElement(noRadioButton).isSelected());



       driver.findElement(impressiveRadioButton).click();
       System.out.println(driver.findElement(yesRadioButton).isSelected());
       System.out.println(driver.findElement(impressiveRadioButton).isSelected());
       System.out.println(driver.findElement(noRadioButton).isSelected());

       driver.findElement(noRadioButton).click();
       System.out.println(driver.findElement(yesRadioButton).isSelected());
       System.out.println(driver.findElement(impressiveRadioButton).isSelected());
       System.out.println(driver.findElement(noRadioButton).isSelected());

//        Prints whether each option is enabled/disabled
//        For enabled options, select them and verify selection
//        Print confirmation message for each successful selection

   }*/@Test
void Radion() throws InterruptedException {
    driver.get("https://demoqa.com/radio-button");

    // إزالة أي إعلانات (iframes)
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.querySelectorAll('iframe').forEach(e => e.remove());");

    // Locate radio buttons
    WebElement yesRadio = driver.findElement(By.id("yesRadio"));
    WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
    WebElement noRadio = driver.findElement(By.id("noRadio"));

    // YES option
    js.executeScript("arguments[0].scrollIntoView(true);", yesRadio);
    if (yesRadio.isEnabled()) {
        driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
        Assertions.assertTrue(yesRadio.isSelected(), "❌ Yes not selected");
        System.out.println("✅ Yes option is enabled and selected successfully");
    } else {
        System.out.println("❌ Yes option is disabled");
    }

    Thread.sleep(1500);

    // IMPRESSIVE option
    js.executeScript("arguments[0].scrollIntoView(true);", impressiveRadio);
    if (impressiveRadio.isEnabled()) {
        driver.findElement(By.cssSelector("label[for='impressiveRadio']")).click();
        Assertions.assertTrue(impressiveRadio.isSelected(), "❌ Impressive not selected");
        System.out.println("✅ Impressive option is enabled and selected successfully");
    } else {
        System.out.println("❌ Impressive option is disabled");
    }

    Thread.sleep(1500);

    // NO option
    js.executeScript("arguments[0].scrollIntoView(true);", noRadio);
    if (noRadio.isEnabled()) {
        driver.findElement(By.cssSelector("label[for='noRadio']")).click();
        Assertions.assertTrue(noRadio.isSelected(), "❌ No not selected");
        System.out.println("✅ No option is enabled and selected successfully");
    } else {
        System.out.println("❌ No option is disabled, cannot be selected");
    }
}

}








