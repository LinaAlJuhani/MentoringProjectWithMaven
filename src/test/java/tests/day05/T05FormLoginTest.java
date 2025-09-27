package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class T05FormLoginTest extends TestBase {

   /*
     Go to https://claruswaysda.github.io/form.html
     Fill the form
     Login the app
     Celebrate the login
     */

    @Test
    void test(){
     driver.get("https://claruswaysda.github.io/form.html");
        Faker faker =new Faker();
     String FirstName = faker.name().firstName();
     String lastName = faker.name().lastName();
     String Address =faker.address().fullAddress();
     String phone =faker.phoneNumber().cellPhone();
     String Username =faker.name().fullName();

     String Email = faker.internet().emailAddress();
     String Password =faker.internet().password(8,12);
        System.out.println("FirstName: " + FirstName);

        System.out.println("lastName: " + lastName);
        System.out.println("Address: " + Address);
        System.out.println("Phone: " + phone);
        System.out.println("Username: " + Username);

        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);
        System.out.println("Confirm Password: " + Password);




        driver.findElement(By.id("first-name")).sendKeys(FirstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("address")).sendKeys(Address);
        driver.findElement(By.id("phone")).sendKeys(phone);

        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("email")).sendKeys(Email);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.id("confirm-password")).sendKeys(Password);


        String enteredPassword = driver.findElement(By.id("password")).getAttribute("value");
        String confirmedPassword = driver.findElement(By.id("confirm-password")).getAttribute("value");

        Assertions.assertEquals(enteredPassword, confirmedPassword, "Passwords do not match!");

        WebElement button = driver.findElement(By.xpath("//button[@class='button']"));
        button.click();


    }
}
