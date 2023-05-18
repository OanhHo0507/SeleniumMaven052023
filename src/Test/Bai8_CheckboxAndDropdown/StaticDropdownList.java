package Test.Bai8_CheckboxAndDropdown;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdownList extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        sleep(2);
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='select-demo']"));

        //Khoi tao
        Select select = new Select(selectElement);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("Kiem tra kieu cua Select: " +select.isMultiple());
        System.out.println("Kiem tra so luong options: " + select.getOptions().size());

        select.selectByIndex(3);
        sleep(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //Select by value
        select.selectByValue("Monday");
        sleep(1);
        System.out.println(select.getFirstSelectedOption().getText());



        closeDriver();

    }
}
