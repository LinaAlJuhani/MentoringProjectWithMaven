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

import java.time.Duration;
import java.util.List;

public class T05DynamicListManagement {

    /*
    Task 5: Dynamic List Management
 Question: Go to "
 http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
 Uses Faker to generate 5 random task names
 Adds all tasks to the todo list
 Marks every other task as completed (strikethrough)
Deletes all completed tasks
 Verifies only incomplete tasks remain   */

    WebDriver driver;
Faker faker;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        faker = new Faker();
        WebDriverManager.chromedriver().setup();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }@AfterEach
    void after(){
        driver.quit();
    }

    @Test
    void dolist() {
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));

       for(int i =0; i<5;i++){
        String task = faker.book().title();
        inputField.sendKeys(task+ Keys.ENTER);


       }


        List<WebElement> LIST =driver.findElements(By.cssSelector("ul li"));

       for (int i=0;i<LIST.size();i++){
           if(i%2==0){
               LIST.get(i).click();
}}
        for (WebElement task : LIST) {
            System.out.println(task.getText());  // يطبع النص داخل المهمة
        }
        List<WebElement> deleteIcons = driver.findElements(By.cssSelector("li span i"));
        for (WebElement deleteIcon : deleteIcons) {
            try {
                deleteIcon.click();
            } catch (Exception ignored) {}
        }


    }}