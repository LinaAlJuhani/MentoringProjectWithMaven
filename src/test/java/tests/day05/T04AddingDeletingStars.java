package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.util.List;

public class T04AddingDeletingStars extends TestBase {

     /*
 Go to https://claruswaysda.github.io/addDeleteStar.html
 Create a method to add given number of stars
 Create a method to delete given numbers of stars
 Create a method to verify the given number of stars deleted
 */

    String url = "https://claruswaysda.github.io/addDeleteStar.html";
 void add (int addNum)  {


    for (int i=0;i<addNum;i++){
        driver.findElement(By.id("push-button")).click();
    }
 }
 void delete(int deleteNum) {

         for (int i = 0; i < deleteNum; i++) {
             driver.findElement(By.id("delete-button")).click();
         }

     }
void verifyStars (int expectecdacount){

    List<WebElement> starts =driver.findElements(By.className("star"));
    Assertions.assertEquals(expectecdacount, starts.size());

}
    @Test
    void testAddDeleteStarsRahaf() throws InterruptedException{
        driver.get(url);

        int addedStars = 10;
        int deletedStars1 = 2;

        add(addedStars);
        Thread.sleep(200);// يضيف 10 نجوم
        delete(deletedStars1); // يحذف 2 نجوم
        Thread.sleep(200);
        int expected = addedStars - deletedStars1;
        verifyStars(expected); // يتأكد أن الباقي = 8
    }

 }






