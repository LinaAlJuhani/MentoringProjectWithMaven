package assignments.day11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class NegativeLoginScenariosTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // @BeforeClass - Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"wrongUser", "wrongPass"},   // both wrong
                {"admin", "wrongPass"},       // correct username, wrong password
                {"wrongUser", "123"},         // wrong username, correct password
                {"", "123"},                  // empty username, correct password
                {"admin", ""},                // correct username, empty password
                {"", ""}                      // both empty
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String usernameInput, String passwordInput) {
        // Step 1: Navigate to login page
        driver.get("https://claruswaysda.github.io/signIn.html");

        // Step 2: Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys(usernameInput);

        // Step 3: Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(passwordInput);

        // Step 4: Click Submit button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Step 5: Always wait for alert (since login should fail)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Verify alert text
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Incorrect username or password"),
                "Unexpected alert message!");

        // Close the alert
        alert.accept();
    }

    @AfterClass
    public void tearDown() {
        // @AfterClass - Close WebDriver
        driver.quit();
    }
}
