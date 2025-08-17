package com.quangtester.Bai09_Mobile_AutomationMethods;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class DemoInputButton_SauceLabs extends BaseTestSauceLabs {
    //Vào trang Login
    @Test
    public void testLoginMyDemoApp() {
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);
    }
}
