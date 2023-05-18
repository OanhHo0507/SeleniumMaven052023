package Test.Bai8_CheckboxAndDropdown;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement radioButton = driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div//label[normalize-space()='Male']/input"));
        System.out.println(radioButton.isSelected());
        if(radioButton.isSelected()== false){
            sleep(1);
            radioButton.click();
        }
        System.out.println("State of Sex option after selected " + radioButton.isSelected());

        //Support for group radio buttons
        WebElement groupRadioButton1 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='0 to 5']/input"));
        WebElement groupRadioButton2 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='5 to 15']/input"));
        WebElement groupRadioButton3 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='15 to 50']/input"));
        System.out.println(groupRadioButton3.isSelected());
        if(groupRadioButton3.isSelected()== false){
            groupRadioButton3.click();
        }
        //Kiem tra trang thai cua 3 radio buttons sau khi 1 trong cac radio button duoc chon.
        System.out.println("State of the 3rd radio after selected: " + groupRadioButton3.isSelected());
        System.out.println("State of the 2nd radio after selected: " + groupRadioButton2.isSelected());
        System.out.println("State of the 1st radio after selected: " + groupRadioButton1.isSelected());

        //close Browser
        closeDriver();
    }
}
