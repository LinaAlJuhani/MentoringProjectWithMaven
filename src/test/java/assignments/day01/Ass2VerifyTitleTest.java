package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ass2VerifyTitleTest {
    public static void main(String[] args) {


        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // Verify the page title contains the word video.
        String title = driver.getTitle();
        if (title.contains("video")) {
            System.out.println("Title test Passed");
        } else {
            System.out.println("Failed! Actual title is: " + title);
        }
        // Close the browser
        driver.quit();
    }
}
