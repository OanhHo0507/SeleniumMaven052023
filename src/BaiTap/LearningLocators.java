package BaiTap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class LearningLocators {
    public static void main(String[] args) throws InterruptedException {

        //Khoi tao 1 browser voi Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver.setProperty("webdriver.Chrome.driver", "/Users/oanhho/Documents/Selenium/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open URL
        driver.get("https://app.hrsale.com/erp/login");
        sleep(1000);

        //Define username and password > Click on Login button
        WebElement username = driver.findElement(By.xpath("//input[@id='iusername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='ipassword']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        sleep(2000);

        //Input value for Username and Password >>> Click on Login button
        username.sendKeys("frances.burns");
        password.sendKeys("frances.burns");
        btnLogin.click();
        sleep(3000);

        //Click on Projects on the left menu
        WebElement projects = driver.findElement(By.xpath("//span[normalize-space()='Projects']"));
        projects.click();
        sleep(2000);

        //Click on Add Project button
        WebElement btnAddProject = driver.findElement(By.xpath("//a[normalize-space()='Add Project']//*[name()='svg']"));
        btnAddProject.click();
        sleep(2000);

        //Define fields in Add Project form
        WebElement title = driver.findElement(By.name("title"));
        title.sendKeys("Project1");

        //Click vào Client dropdown Category
        driver.findElement(By.xpath("//span[normalize-space()='Client']")).click();
        sleep(1);
        //driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).click();
        //Search giá trị cần chọ
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/input")).sendKeys("Ashley Lawson");
        sleep(1);
        //Click chọn Text đã search (cần chọn)
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform(); //Cách ENTER dùng cho TH chỉ hiển thị 1 giá trị lựa chọn

        //Define Estimate Hour element
        WebElement estimate = driver.findElement(By.name("budget_hours"));
        estimate.sendKeys("1");

        //Click vào Priority dropdown Category
        driver.findElement(By.xpath("//span[contains(@id, 'select2-priority')]")).click();
        sleep(1);

        //Search giá trị cần chọ
        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/input")).sendKeys("Normal");
        sleep(1);

        //Click chọn Text đã search (cần chọn)
        Actions action1 = new Actions(driver);
        action1.sendKeys(Keys.ENTER).perform(); //Cách ENTER dùng cho TH chỉ hiển thị 1 giá trị lựa chọn

        //Define Start Date elenment
        WebElement StartDate = driver.findElement(By.xpath("//label[contains(text(),'Start Date')]/following-sibling::div"));
        StartDate.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='22']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
        Thread.sleep(1000);

        //Define End Date element
       // while (!driver.findElement(By.xpath("//div[@class='dtp-date']/following::div[@class='dtp-actual-month p80']")).getText().contains("DEC"))
        //{
         //   driver.findElement(By.xpath("//div[@class='dtp-date']/following::a[@class='dtp-select-month-after']")).click();
        //}
        driver.findElement(By.name("end_date")).click();
        List<WebElement> listEndDate = driver.findElements(By.xpath("//table[@class='table dtp-picker-days']/following::a[@class='dtp-select-day']"));
        int count = driver.findElements(By.xpath("//table[@class='table dtp-picker-days']/following::a[@class='dtp-select-day']")).size();
        System.out.println("Number of days: " + count);
        Thread.sleep(2000);
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.xpath("//table[@class='table dtp-picker-days']/following::a[@class='dtp-select-day']")).get(i).getText();
            if (text.equalsIgnoreCase("31")){
                driver.findElements(By.xpath("//table[@class='table dtp-picker-days']/following::a[@class='dtp-select-day']")).get(i).click();
                break;
            }
        }
       driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();


        //Close browser
        driver.quit();


    }
}
