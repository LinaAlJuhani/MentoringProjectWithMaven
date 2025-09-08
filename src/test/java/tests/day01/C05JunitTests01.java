package tests.day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05JunitTests01 {
// TC - 07
// Go to YouTube homepage
// Do the following tasks by creating 4 different test methods.
//*- Print "Test is running" before each test() method
// *- Print "Test finished" after each test() method
// Test if the currentURL contains "youtube"
// Test if the title does not contain "Video".
// Test if the URL contains "youtube".
// Test if the sourcePage contains "youtube".

    static WebDriver driver;

    @Test
    void urlTest01(){
        System.out.println("urlTest01");
        System.out.println("currentURL contains \"youtube\" test is executed ...");
       String currentUrl = driver.getCurrentUrl();
       Assertions.assertTrue(currentUrl.contains("youtube"));
    }
    @Test
    void titleTest01 (){
        System.out.println("titleTest01");
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));
    }
    @Test
    void  urlTest02() {
        System.out.println("urlTest02");
        System.out.println("currentURL contains \"youtube\" test is executed ...");
        String Url = driver.getCurrentUrl();
        Assertions.assertTrue(Url.contains("youtube"));
    }
    @Test
    void pageSourceTest01(){
        System.out.println("pageSourceTest01");
        System.out.println("sourcePage contains \"youtube\" test is executed ...");
        Assertions.assertTrue(driver.getPageSource().contains("youtube"));
    }

    @BeforeAll
    public static void setup(){
        // static void setUp(){
         driver = new ChromeDriver();
         driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
    }
    @BeforeEach
    void BeforeEach(){
        System.out.println("Test is running");
    }
    @AfterEach
    void AfterEach(){
    System.out.println("Tst is finished");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
