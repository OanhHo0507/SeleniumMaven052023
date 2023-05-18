package Test.Bai5_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class testSelenium {
    public static void main(String[] args) throws InterruptedException {

        //Khoi tao 1 browser voi Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver.setProperty("webdriver.Chrome.driver", "/Users/oanhho/Documents/Selenium/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open anhtester.com browser
        driver.get("https://anhtester.com/");

        //click on Login button
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();

        //Click on X button from Login popup
        driver.findElement(By.xpath("//a[contains(text(),'home')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Cucumber TestNG Basic to Advanced")).click();
        Thread.sleep(2000);
        String description = driver.findElement(By.linkText("Cucumber TestNG Basic to Advanced")).getText();
        System.out.println(description);

        //Close browser
        driver.quit();
    }
}
