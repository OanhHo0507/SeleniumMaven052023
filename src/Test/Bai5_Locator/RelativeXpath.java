package Test.Bai5_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {
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

        //Enter username and password with xpath tuong doi
        driver.findElement(By.xpath("//input[contains(@name,'iusername')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//span[@class='ladda-label'][contains(.,'Login')]")).click();

        //Close browser
        driver.quit();
    }
}
