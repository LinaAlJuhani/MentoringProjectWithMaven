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

public class T10JQueryEmojiPicker {
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
    void iframeTest() {
        // Go to URL: http://demo.guru99.com/test/guru99home/

        // Find the number of iframes on the page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes on the page: " + iframes.size());

        // Switch to the second iframe (index = 1, JMeter Made Easy)
        driver.switchTo().frame(1);

        // Click the link (https://www.guru99.com/live-selenium-project.html)
        WebElement jmeterLink = driver.findElement(By.xpath("//a[contains(@href,'live-selenium-project.html')]"));
        jmeterLink.click();

        // Exit the iframe and return to the main page
        driver.switchTo().defaultContent();
    }
}
