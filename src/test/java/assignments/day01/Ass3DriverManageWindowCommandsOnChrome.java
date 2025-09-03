package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass3DriverManageWindowCommandsOnChrome {
    public static void main(String[] args) {
        // Go to the Amazon URL : https://www.amazon.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        // Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);

        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("dimensions.getWidth() = " + dimensions.getWidth());
        System.out.println("dimensions.getHeight() = " + dimensions.getHeight());
        System.out.println("dimensions = " + dimensions);

        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(100, 50));
        driver.manage().window().setSize(new Dimension(800, 600));

        // Close the page.
        driver.quit();
    }
}
