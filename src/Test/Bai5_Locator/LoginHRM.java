package Test.Bai5_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHRM {
    public static void main(String[] args) throws InterruptedException {

        //Khoi tao 1 browser voi Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver.setProperty("webdriver.Chrome.driver", "/Users/oanhho/Documents/Selenium/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open URL
            driver.get("https://app.hrsale.com/");
        Thread.sleep(1000);

        //Enter username and password with xpath tuyet doi
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/button[1]/span[1]")).click();


        //click on Login button
        //driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //Close browser
        driver.quit();
    }
}
