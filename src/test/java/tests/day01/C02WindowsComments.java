package tests.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02WindowsComments {
    public static void main(String[] args) throws InterruptedException {
        // TC - 02
        WebDriver driver = new ChromeDriver();
        // Go to www.yahoo.com
        driver.get("https://www.linkedIn.com");
// Maximize Window
        driver.manage().window().maximize();
        Thread.sleep(1000);

// Go to www.amazon.com
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
// Maximize Window
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
// Navigate Back
        driver.navigate().back();
        Thread.sleep(1000);
        // Navigate Forward
        driver.navigate().forward();
        Thread.sleep(1000);
        // Refresh The Page
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.quit();
    }


}
