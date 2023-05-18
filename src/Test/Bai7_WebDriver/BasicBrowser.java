package Test.Bai7_WebDriver;

import Test.Common.BaseTest;
import org.openqa.selenium.By;

public class BasicBrowser extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.navigate().to("https://app.hrsale.com/erp/login");
        sleep(2);
        //Enter username and password with xpath tuong doi
        driver.findElement(By.xpath("//input[contains(@name,'iusername')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//span[@class='ladda-label'][contains(.,'Login')]")).click();
        driver.navigate().back();
        driver.navigate().refresh();



        closeDriver();
    }
}
