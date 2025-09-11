package assignments.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T07MultiSelectTest {
    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    void multiSelectOperations() throws InterruptedException {
        // Select Standard Multi-Select using element id
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(multiSelectElement);

        // Verify element is multi-select
        System.out.println("Is multi-select? " + multiSelect.isMultiple());

        // Select 'Opel' using index, then deselect using index
        multiSelect.selectByIndex(2); // Opel
        Thread.sleep(1000);
        multiSelect.deselectByIndex(2);

        // Select 'Saab' using value, then deselect using value
        multiSelect.selectByValue("saab");
        Thread.sleep(1000);
        multiSelect.deselectByValue("saab");

        // Deselect all options
        multiSelect.deselectAll();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
