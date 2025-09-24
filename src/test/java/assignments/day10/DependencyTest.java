package assignments.day10;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DependencyTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // @BeforeClass - Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openYahoo() {
        // First test method - Navigate to Yahoo
        // Intentional failure added here
        driver.get("https://www.yahoo.com");
        throw new RuntimeException("Intentional Failure");
    }

    @Test(dependsOnMethods = {"openYahoo"})
    public void openBing() {
        // Second test method - depends on Yahoo
        driver.get("https://www.bing.com");
    }

    @Test(dependsOnMethods = {"openBing"})
    public void openDuckDuckGo() {
        // Third test method - depends on Bing
        driver.get("https://www.duckduckgo.com");
    }

    @AfterClass
    public void tearDown() {
        // @AfterClass - Close WebDriver
        driver.quit();
    }
}
