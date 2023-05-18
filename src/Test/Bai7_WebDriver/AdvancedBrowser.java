package Test.Bai7_WebDriver;

import Test.Common.BaseTest;
import org.openqa.selenium.WindowType;

public class AdvancedBrowser extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://anhtester.com");

        // mo tab moi tren cung browser
        driver.switchTo().newWindow(WindowType.TAB);

        //mo tab moi tren browser moi
        //driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://google.com");

        closeDriver();
    }
}
