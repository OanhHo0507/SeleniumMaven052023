package Test.Bai5_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginECommerce {
    public static void main(String[] args) throws InterruptedException {

        //Khoi tao 1 browser voi Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver.setProperty("webdriver.Chrome.driver", "/Users/oanhho/Documents/Selenium/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open URL
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        //Enter username and password
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");

        //Click on "Forgot Password?" link
        driver.findElement(By.linkText("Forgot password ?")).click();

        //click on Login button
        //driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //Close browser
        driver.quit();
    }
}
