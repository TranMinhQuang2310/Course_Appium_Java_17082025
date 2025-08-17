package com.quangtester.Bai13_HandleFlutterApp;

import com.quangtester.common.Bai13_BaseTestFlutterPlatform;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class DemoHandleFlutterApp extends Bai13_BaseTestFlutterPlatform {
    //Chạy lỗi
    @Test
    public void testLoginTaurusApp() {
        //DriverManager.getDriver().findElement(AppiumBy.xpath(""));
        MobileUI.sleep(2);
        flutterFinder.byValueKey("txt-email").sendKeys("admin");
        MobileUI.sleep(1);
        flutterFinder.byValueKey("txt-password").sendKeys("admin");
        MobileUI.sleep(1);
        flutterFinder.byText("Sign in").click();
        MobileUI.sleep(3);
    }
}
