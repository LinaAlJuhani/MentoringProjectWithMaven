package tests.day03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class T05DynamicListManagement {

    WebDriver driver;
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";
    Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    void testDynamicTodoList() {
        // TODO: Generate 5 random tasks
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(faker.book().title());
        }

        // TODO: Add all tasks to the todo list
        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        for (String task : tasks) {
            inputBox.sendKeys(task);
            inputBox.sendKeys(Keys.ENTER); // press Enter to add task
        }

        // TODO: Mark every other task as completed (strikethrough)
        List<WebElement> allTasks = driver.findElements(By.xpath("//ul[@id='container']/li"));
        for (int i = 0; i < allTasks.size(); i++) {
            if (i % 2 == 0) { // every other task
                allTasks.get(i).click();
            }
        }

        // TODO: Delete all completed tasks
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//li[@class='completed']/span"));
        for (WebElement deleteBtn : deleteButtons) {
            deleteBtn.click();
        }

        // TODO: Verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.xpath("//ul[@id='container']/li"));
        for (WebElement task : remainingTasks) {
            Assertions.assertFalse(task.getAttribute("class").contains("completed"));
        }

        System.out.println("Remaining tasks count: " + remainingTasks.size());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
