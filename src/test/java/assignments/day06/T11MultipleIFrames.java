package assignments.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T11MultipleIFrames {

    WebDriver driver;
    String url = "http://demo.guru99.com/test/guru99home/";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void multipleIframesTest() {
        // Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get(url);

        // Find the number of iframes on the page
        List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes on the page: " + allIframes.size());

        // Switch to the third iframe (JMeter Made Easy)
        if (allIframes.size() >= 3) {
            driver.switchTo().frame(2); // index starts from 0

            // Click the link (https://www.guru99.com/live-selenium-project.html)
            WebElement link = driver.findElement(By.xpath("//a[contains(text(),'JMeter Made Easy')]"));
            link.click();

            // Exit the iframe and return to the main page
            driver.switchTo().defaultContent();
        } else {
            System.out.println("Less than 3 iframes on this page. Could not switch to the third iframe.");
        }
    }
}
