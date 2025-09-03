package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass4DriverManageWindowCommandsOnChrome {
    public static void main(String[] args) throws InterruptedException{

        // Open URL: https://www.google.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // Maximize the window.
        driver.manage().window().maximize();

        // Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);

        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("dimensions.getWidth() = " + dimensions.getWidth());
        System.out.println("dimensions.getHeight() = " + dimensions.getHeight());
        System.out.println("dimensions = " + dimensions);

        // Minimize the page.
        driver.manage().window().minimize();

        // Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state.
        Point newPosition = driver.manage().window().getPosition();
        System.out.println("newPosition.getX() = " + newPosition.getX());
        System.out.println("newPosition.getY() = " + newPosition.getY());
        System.out.println("newPosition = " + newPosition);

        Dimension newDimensions = driver.manage().window().getSize();
        System.out.println("newDimensions.getWidth() = " + newDimensions.getWidth());
        System.out.println("newDimensions.getHeight() = " + newDimensions.getHeight());
        System.out.println("newDimensions = " + newDimensions);

        // Make the page fullscreen.
        driver.manage().window().fullscreen();

        // Close the Browser.
        driver.quit();

    }
}
