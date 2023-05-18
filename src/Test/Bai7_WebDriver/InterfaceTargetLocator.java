package Test.Bai7_WebDriver;

import Test.Common.BaseTest;

public class InterfaceTargetLocator extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://demoqa.com");
        closeDriver();
    }
}
