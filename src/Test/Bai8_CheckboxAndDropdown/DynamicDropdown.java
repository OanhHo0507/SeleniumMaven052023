package Test.Bai8_CheckboxAndDropdown;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DynamicDropdown extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");

        //Click on Select a category dropdown list
        driver.findElement(By.xpath("//span[normalize-space() = 'Select a Category']")).click();
        sleep(1);

        //Search a value from dropdown list
        driver.findElement(By.xpath("//span[normalize-space() = 'Select a Category']/parent::a/following-sibling::div//input")).sendKeys("Hotels");
        sleep(1);

        //Cach 1: Click on the selected value from dropdown list
        driver.findElement(By.xpath("//li[@class = 'active-result highlighted']")).click();

        //Cach 2: Click on ENTER key to select value
        Actions action1 = new Actions(driver);
        action1.sendKeys("Keys.ENTER").perform();


        closeDriver();

    }
}
