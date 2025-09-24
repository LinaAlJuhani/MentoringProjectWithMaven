package tests.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {
/*
    Task 4: Faker Data Form Filling
    Question: Go to "
    https://demoqa.com/text-box". Use Java Faker to:
    Generate and enter a fake full name
    Generate and enter a fake email address
    Generate and enter a fake current address
    Generate and enter a fake permanent address
    Submit the form and verify the output contains the entered data
    */

    WebDriver driver;



    @Test
    void fakerTest()throws InterruptedException{

        driver.get("https://demoqa.com/text-box");
        Faker faker = new Faker();

        //Generate and enter a fake full name
        String fullname = faker.name().fullName();
        System.out.println("full name = "+fullname);
        driver.findElement(By.id("userName")).sendKeys(fullname);
        Thread.sleep(3000);

        //Generate and enter a fake email address

        String email =faker.internet().emailAddress();
        System.out.println("email:"+email);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        Thread.sleep(3000);

       // Generate and enter a fake current address

        String address = faker.address().fullAddress();
        System.out.println("addres"+ address);
        driver.findElement(By.id("currentAddress")).sendKeys(address);
        Thread.sleep(3000);


        String addresspa = faker.address().fullAddress();
        System.out.println("addres"+ addresspa);
        driver.findElement(By.id("permanentAddress")).sendKeys(addresspa);
        Thread.sleep(3000);

        //Submit the form and verify the output contains the entered data
        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);


       WebElement output= driver.findElement(By.id("output"));
        System.out.println(output.getText());
        Assertions.assertTrue(output.getText().contains(fullname));

     /*   WebElement output = driver.findElement(By.id("output"));

        System.out.println("driver.findElement(By.xpath(\"//p[@class='mb-1'][1]\")).getText() = " + driver.findElement(By.xpath("//p[@class='mb-1'][1]")).getText());
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='mb-1'][1]")).getText().contains(fullName));
*/
    }



    @BeforeEach
    void setup() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterEach
    void after(){
        driver.quit();
    }






}

