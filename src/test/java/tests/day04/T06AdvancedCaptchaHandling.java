package tests.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T06AdvancedCaptchaHandling {
    /*
    Task 6: Advanced Captcha Handling
 Question: Go to "
 https://form.jotform.com/73302671092956" and extend the provided captcha example
 to handle division operations. Modify the code to:
 Handle division (/) operations in addition to +, -, *
 Round division results to the nearest integer
 Add error handling for division by zero
 Log each calculation step to console
     */
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void after() {
        driver.quit();
    }

    @Test
    void test(){
driver.get("https://form.jotform.com/73302671092956");









    }
}