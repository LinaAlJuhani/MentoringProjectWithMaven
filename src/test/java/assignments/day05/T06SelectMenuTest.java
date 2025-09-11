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
import java.util.List;

public class T06SelectMenuTest {

    WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    @BeforeEach
    void setUp() {
        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }

    @Test
    void oldStyleSelectMenuTest() {
        // Open https://demoqa.com/select-menu
        driver.get(url);

        // Select Old Style Select Menu using element id
        WebElement menu = driver.findElement(By.id("oldSelectMenu"));
        Select drop = new Select(menu);

        // Print all dropdown options
        List<WebElement> options = drop.getOptions();
        System.out.println("=== All options in Old Style Select Menu ===");
        for (WebElement o : options) {
            System.out.println(o.getText());
        }

        // Select 'Purple' using index
        drop.selectByIndex(4);

        // Select 'Magenta' using visible text
        drop.selectByVisibleText("Magenta");

        // Select an option using value (Black = value "5")
        drop.selectByValue("5");
    }
}
