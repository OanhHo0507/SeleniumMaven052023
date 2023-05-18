package Test.Practice;

import Test.Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;

public class ClientCRM extends BaseTest {

    //logim to CRM system
    public static void signinCRM(){
        driver.get("https://rise.fairsketch.com/signin");
        //clear default values of username and password before inputting new ones
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        sleep(1);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }

    public static void clientCRM(){
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        //driver.findElement(By.xpath("(//a[normalize-space()='Clients'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='page-content']//a[normalize-space()='Clients']")).click();
        sleep(1);

    }

    public static void addClient(String clientName) {
        driver.findElement(By.xpath("//a[contains(@title,'Add client')]")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@id = 'company_name']")).sendKeys(clientName);
        driver.findElement(By.xpath("//div[@id='s2id_created_by']")).click();
        sleep(1);

        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Sara Ann");
        Actions action1 = new Actions(driver);
        action1.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.id("address")).sendKeys("Address city state zip 123 example adddress");
        driver.findElement(By.id("city")).sendKeys("HCM");
        driver.findElement(By.id("state")).sendKeys("HCM");
        driver.findElement(By.id("zip")).sendKeys("70000");
        driver.findElement(By.id("country")).sendKeys("VietNam");

        //Scroll down to the last element so that user can view all the fields
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[normalize-space()='Disable online payment']")));


        driver.findElement(By.id("phone")).sendKeys("123456789");
        driver.findElement(By.id("website")).sendKeys("http://google.com");
        driver.findElement(By.id("vat_number")).sendKeys("234533334");
        driver.findElement(By.id("gst_number")).sendKeys("0122233");
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']//input")).sendKeys("VIP", Keys.ENTER);

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }
    //search client after adding successfull
    public static void checkClientSuccess(String clientName){
        sleep(2);
        driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(clientName);
        sleep(2);
        String clientNameInTable = driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr[1]//td[2]")).getText();
        System.out.println(clientNameInTable);
        }
    public static void main(String[] args) {
        createDriver();
        signinCRM();
        clientCRM();
        addClient("ABC");
        checkClientSuccess("ABC");
        closeDriver();
    }
}


