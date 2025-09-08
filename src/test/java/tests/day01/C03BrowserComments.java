package tests.day01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {
    public static void main(String[] args) {
        // Expected Title
        String expTitle = "Google";

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open URL of Website
        driver.get("https://www.google.com/");

        // Maximize Window
        driver.manage().window().maximize();

        // Get Title of current Page
        String actualTitle = driver.getTitle();

        // Validate/Compare Page Title

        if (actualTitle.equals(expTitle)) {
            System.out.println("page title appear as expected");
        } else {
            System.out.println("page title does not appear as expected");
        }

        // Close Browser
        driver.quit();
    }
}
