package Test.Bai7_WebDriver;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListWebDriver extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        createDriver();
        driver.get("https://app.hrsale.com/erp/login");

        //Enter username and password with xpath tuong doi
        driver.findElement(By.xpath("//input[contains(@name,'iusername')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//span[@class='ladda-label'][contains(.,'Login')]")).click();

        Thread.sleep(6000);
        //Liet ke toan bo list of menu on the left side - lay nhieu elements
        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@class='pc-navbar' ]/li"));
        for (int i=0; i < listMenu.size(); i++) {
            System.out.println("List of menu on the left pane: " + listMenu.get(i).getText());
        }

        closeDriver();
    }
}
