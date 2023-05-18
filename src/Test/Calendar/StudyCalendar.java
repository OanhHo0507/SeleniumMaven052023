package Test.Calendar;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class StudyCalendar extends BaseTest{
    public static void main(String[] args) throws InterruptedException {
        createDriver();
        driver.get("https://path2usa.com/travel-companions");
        Thread.sleep(3000);

        //Scroll down to Date of travel field
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        //Thread.sleep(2000);

        //Select a date from Date of travel field
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]"));
        int count = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]")).size();
        Thread.sleep(2000);
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]")).get(i).getText();
            if (text.equalsIgnoreCase("12")){
                driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]")).get(i).click();
                break;
            }
        }
        closeDriver();
    }
}
