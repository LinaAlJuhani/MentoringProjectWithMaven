package MorningSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySecondJUnitJupiterTests {
WebDriver driver;
  @Test
  void  mypassingTest() throws InterruptedException{
   driver.get("https://www.selenium.dev/selenium/web/web-form.html");

   driver.findElement(By.id("my-text-id")).sendKeys("My", Keys.TAB , "FIRST",Keys.TAB,"text");
      Thread.sleep(5000);
  }
    @Test
    void loginToSauceDemo() {
        driver.get("https://www.saucedemo.com/");

        // option #1: industry standard

        //  By passwordInput = By.id("password");
        //By loginButton = By.id("login-button");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

 @BeforeEach
    void BeforeEachTest(){
     driver =new ChromeDriver();
     driver.manage().window().maximize();
  }
    @AfterEach
    void AfterEachTest(){
        driver.quit();
    }














}
