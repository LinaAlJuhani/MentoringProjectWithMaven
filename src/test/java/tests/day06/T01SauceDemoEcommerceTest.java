package tests.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class T01SauceDemoEcommerceTest extends TestBase {

    /*
     Task 1: SauceDemo E-commerce Test
 Given: Go to https://www.saucedemo.com/
 When: Enter username as "standard_user"
 And: Enter password as "secret_sauce"
And: Click login button
 And: Order products by "Price (low to high)"
 Then: Assert last product costs $49.99, first product costs $7.99
     */
    @Test
            void test() {
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));

        sortDropdown.selectByValue("lohi");

        List<WebElement> PRICE = driver.findElements(By.className("inventory_item_price"));

        List<Double> pricevalues = new ArrayList<>();
        for(WebElement Price : PRICE){
            pricevalues.add(Double.parseDouble(Price.getText().replace("$", "")));
            System.out.println(Price.getText());
        }

        Assertions.assertEquals(7.99, pricevalues.get(0));
        Assertions.assertEquals(49.99, pricevalues.get(5));


    }
}
