package Test.Bai8_CheckboxAndDropdown;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkbox extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        //Kiểm tra check box đã được check hay chưa
        Boolean isSelected = driver.findElement(By.id("isAgeSelected")).isSelected();

        //Nếu chưa được check thì click vào ô check box đó
        if (isSelected == false) {
            driver.findElement(By.id("isAgeSelected")).click();
        }
        //Check xem checkbox đã được check và in kết quả này ra màn hình //(có thể là true hoặc false)

        System.out.println(driver.findElement(By.id("isAgeSelected")).isSelected());
        WebElement message = driver.findElement(By.id("txtAge"));
        System.out.println("The message after checkbox is checked is : " + message.getText());

        // CASE 2: HANDLE MULTI CHECKBOXES

        //List out all checkboxes
        List<WebElement> listCheckbox = driver.findElements(By.xpath("//div[normalize-space()='Multiple Checkbox Demo']/following-sibling::div//input[@type='checkbox']"));

        System.out.println("Number of checkboxes: " + listCheckbox.size());

        //Duyet List tren de lay ra tung thang checkbox
        for (int i = 1; i <= listCheckbox.size(); i++) {
            //Lay ra tung vi tri checkbox theo thu tu bat dau tu 0
            sleep(1);
            driver.findElement(By.xpath("//label[normalize-space()='Option " + i + "']")).click();
        }
        for (int i = 1; i <= listCheckbox.size(); i++) {
            sleep(1);
            //Tao bien luu gia tri True False de if else (dat dieu kien)
            boolean isSelected1 = driver.findElement(By.xpath("//label[normalize-space()='Option " + i + "']/input")).isSelected();
            //Cach lay tung item (WebElement) trong List de so sanh
            if (isSelected1 == true) {

                System.out.println("Vi tri thu " + i + " Checked");
            }
        }
            closeDriver();
        }
}