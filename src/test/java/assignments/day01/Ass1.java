package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1 {
    public static void main(String[] args) {
        // create main method
        // create chrome driver
        WebDriver driver = new ChromeDriver();

        // open google home page: https://www.google.com
        driver.get("https://www.google.com");

        // Get Title on page
        String title = driver.getTitle();
        System.out.println("Title = " + title);

        // Get Current URL on page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL = " + currentUrl);

        // Close/Quit the browser
        driver.close();
        driver.quit();



    }
}
