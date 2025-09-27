package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/*

 */
public  class Dummy {
    WebDriver driver;
Faker faker =new Faker();
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void testIframeAndNotification() throws InterruptedException{
        driver.get("https://demoqa.com/frames");

        List<WebElement> IFRAMES = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe size"+IFRAMES.size());

        driver.switchTo().frame("frame1");
        WebElement MASS = driver.findElement(By.id("sampleHeading"));
        System.out.println("mass"+MASS.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");

        WebElement MASS2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("mass2"+MASS2.getText());



}


    }











