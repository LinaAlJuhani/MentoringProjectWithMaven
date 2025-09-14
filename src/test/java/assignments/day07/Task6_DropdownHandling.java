package assignments.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task6_DropdownHandling {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void dropdownHandlingTest() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        WebElement traditional = driver.findElement(By.id("carSelect"));
        Select select1 = new Select(traditional);
        select1.selectByVisibleText("Ford");
        Thread.sleep(1000);

        WebElement multi = driver.findElement(By.id("multiCarSelect"));
        Select select2 = new Select(multi);
        select2.selectByVisibleText("Mercedes");
        Thread.sleep(1000);

        WebElement customDropdown = driver.findElement(By.id("customDropdown"));
        customDropdown.click();
        WebElement bmwOption = driver.findElement(By.xpath("//div[@id='customList']//div[text()='BMW']"));
        bmwOption.click();
        Thread.sleep(1000);

        WebElement teslaModel3 = driver.findElement(By.xpath("//div[@id='staticSuggestions']//div[text()='Tesla Model 3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", teslaModel3);
        Thread.sleep(1000);

        WebElement dynamicInput = driver.findElement(By.id("dynamicInput"));
        dynamicInput.sendKeys("Toy");
        Thread.sleep(1000);
        WebElement toyotaOption = driver.findElement(By.xpath("//div[@id='dynamicSuggestions']//div[text()='Toyota']"));
        toyotaOption.click();
        Thread.sleep(2000);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
