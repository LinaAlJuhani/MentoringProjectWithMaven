package tests.day04;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class T07ComplexFormAutomation {

    WebDriver driver;
    Faker faker;

    @BeforeEach
    void setup() {
        faker = new Faker();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


@AfterEach
void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}
@Test
    void completeRegistrationFlow() throws InterruptedException {
    driver.get("https://demoqa.com/automation-practice-form");
String firstName  = faker.name().firstName();
String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobile = faker.number().digits(10);

    driver.findElement(By.id("firstName")).sendKeys(firstName);
    driver.findElement(By.id("lastName")).sendKeys(lastName);
    driver.findElement(By.id("userEmail")).sendKeys(email);
    Thread.sleep(2000);

    WebElement maleRadio = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
    maleRadio.click();

Thread.sleep(2000);

    driver.findElement(By.id("userNumber")).sendKeys(mobile);

    Thread.sleep(2000);


WebElement SUBJECT = driver.findElement(By.id("subjectsContainer"));
    SUBJECT.sendKeys("Maths" );
    SUBJECT.sendKeys(Keys.ENTER);
    Thread.sleep(2000);


    WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
    hobbies.click();

    Thread.sleep(2000);

    WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
    System.out.println("✅ Result: " + modalTitle.getText());
}

}
















