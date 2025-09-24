package tests.day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08GoogleSearchTest {

    static WebDriver driver;
    String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};

    static String url = "https://www.google.com";

    @BeforeAll
    public static void setUp()throws InterruptedException {


        // TODO: Initialize static WebDriver

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO: Navigate to Google

        driver.get(url);
        //Thread.sleep(2000);



    }
        @Test
    public void searchMovies()throws InterruptedException {

        for(String movie : movies) {
            // TODO: Find search box
          WebElement searchBbox= driver.findElement(By.name("q"));
            // TODO: Clear and enter movie name
            searchBbox.clear();
            searchBbox.sendKeys(movie , Keys.ENTER);
            // TODO: Submit search
            Thread.sleep(2000); // ا



            // TODO: Get and print result count

            // TODO: Clear search box for next iteration

            searchBbox.clear();
        }
    }

    @AfterAll
    public static void tearDown() {
        // TODO: Close driver
    }




}
