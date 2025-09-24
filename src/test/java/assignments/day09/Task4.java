package assignments.day09;

import com.github.javafaker.Faker;
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

public class Task4{
    WebDriver driver;
    Faker faker;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        faker = new Faker();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void findYoungestRecord() throws InterruptedException {
        // Add 10 records
        for (int i = 0; i < 10; i++) {
            String name = faker.name().firstName();
            String age = String.valueOf(faker.number().numberBetween(18, 60));

            driver.findElement(By.id("nameInput")).clear();
            driver.findElement(By.id("nameInput")).sendKeys(name);

            driver.findElement(By.id("ageInput")).clear();
            driver.findElement(By.id("ageInput")).sendKeys(age);

            new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText("USA");

            driver.findElement(By.xpath("//button[text()='Add Record']")).click();

            Thread.sleep(500);

            System.out.println("Row added: " + name + " - " + age);
        }

        Thread.sleep(1000);

        // Get all rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='recordTable']//tbody/tr"));

        if (rows.isEmpty()) {
            System.out.println(" Table is still empty!");
            return;
        }

        // Assume first record is youngest
        String youngestName = rows.get(0).findElement(By.xpath("./td[1]")).getText();
        int youngestAge = Integer.parseInt(rows.get(0).findElement(By.xpath("./td[2]")).getText());

        // Compare with all rows
        for (int i = 1; i < rows.size(); i++) {
            String name = rows.get(i).findElement(By.xpath("./td[1]")).getText();
            int age = Integer.parseInt(rows.get(i).findElement(By.xpath("./td[2]")).getText());

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }

        System.out.println("Youngest person: " + youngestName + " (Age: " + youngestAge + ")");
    }
}
