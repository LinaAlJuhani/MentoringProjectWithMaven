package assignments.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Task5_FormHandlingJSExecutor {

    static WebDriver driver;
    static JavascriptExecutor js;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    // method to flash elements
    public static void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
            js.executeScript("arguments[0].style.backgroundColor = '" + bgColor + "'", element);
        }
    }

    @Test
    void formHandlingTest() {
        driver.get("https://claruswaysda.github.io/form.html");

        // === Register ===
        WebElement firstName = driver.findElement(By.id("first-name"));
        flash(firstName);
        firstName.sendKeys("Ali");

        WebElement lastName = driver.findElement(By.id("last-name"));
        flash(lastName);
        lastName.sendKeys("Test");

        WebElement address = driver.findElement(By.id("address"));
        flash(address);
        address.sendKeys("Test Street 123");

        WebElement phone = driver.findElement(By.id("phone"));
        flash(phone);
        phone.sendKeys("1234567890");

        WebElement username = driver.findElement(By.id("username"));
        flash(username);
        username.sendKeys("testUser");

        WebElement email = driver.findElement(By.id("email"));
        flash(email);
        email.sendKeys("test@mail.com");

        WebElement password = driver.findElement(By.id("password"));
        flash(password);
        password.sendKeys("123456");

        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        flash(confirmPassword);
        confirmPassword.sendKeys("123456");

        WebElement registerBtn = driver.findElement(By.xpath("//button[text()='Register']"));
        flash(registerBtn);
        registerBtn.click();

        // === Login ===
        WebElement loginUsername = driver.findElement(By.id("login-username"));
        flash(loginUsername);
        loginUsername.sendKeys("testUser");

        WebElement loginPassword = driver.findElement(By.id("login-password"));
        flash(loginPassword);
        loginPassword.sendKeys("123456");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
        flash(loginBtn);
        loginBtn.click();

        // Celebrate login!
        WebElement successMessage = driver.findElement(By.id("success-message"));
        Assertions.assertTrue(successMessage.isDisplayed(), "Login was not successful!");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
