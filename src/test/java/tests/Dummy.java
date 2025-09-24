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

            driver.get("http://demo.guru99.com/test/guru99home/");

         //   List<WebElement> frame = driver.findElements(B)







        }


    }








