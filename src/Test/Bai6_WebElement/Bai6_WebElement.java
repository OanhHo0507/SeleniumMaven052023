package Test.Bai6_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai6_WebElement {
    public static void main(String[] args) throws InterruptedException {

        //Khoi tao 1 browser voi Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver.setProperty("webdriver.Chrome.driver", "/Users/oanhho/Documents/Selenium/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open URL
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        Thread.sleep(1000);

        //Define Email element
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("admin@example.com");

        //Define Remember checkbox element
        WebElement remember = driver.findElement(By.id("remember"));
        WebElement remember1 = driver.findElement(By.xpath("//span[normalize-space() = 'Remember Me']"));

        //Define Password element
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        //Define Login element
        WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        //Get Text on Login page
        WebElement Title = driver.findElement(By.xpath("//div[@class='mb-5 text-center']/h1"));
        System.out.println("Title of login page: " + Title.getText().trim());

        //Check if default Remember checkbox is checked or not
        if (remember.isSelected() == false) {
            System.out.println("'Remember me' checkbox is : " + remember.isSelected());
        }
        //Check on "Remember Me" checkbox and print out
        remember1.click();
        System.out.println("'Remember me' checkbox is : " + remember.isSelected());

        //Check the background color of Login button
        System.out.println("Background color of Login button: " + login.getCssValue("background-color"));

        //Check if Copy button is enable >>> Then click on Login button
        WebElement  btnCopy = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
        if (btnCopy.isDisplayed() == true) {
            System.out.println("The state of Copy button on Login page: " + btnCopy.isDisplayed());
            //login.click();
            login.submit(); // Ham submit() chi su dung duoc thi attributes of object phai co type = Submit
        }

        //Check if the page is loaded
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Active eCommerce")) {
            System.out.println("Page is loaded");
        } else {
            System.out.println("Page is not loaded");
        }

        //Close the browser
        driver.close();
    }
}
