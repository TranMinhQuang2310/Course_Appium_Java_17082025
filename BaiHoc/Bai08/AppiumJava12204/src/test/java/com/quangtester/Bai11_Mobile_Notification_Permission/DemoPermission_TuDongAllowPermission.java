package com.quangtester.Bai11_Mobile_Notification_Permission;

import com.quangtester.common.Bai11_BaseTestSauceLabs_TuDongChoPhepPermission;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class DemoPermission_TuDongAllowPermission extends Bai11_BaseTestSauceLabs_TuDongChoPhepPermission {
    //Tự động allow permission thông qua class "Bai11_BaseTestSauceLabs_TuDongChoPhepPermission"
    @Test
    public void testAcceptPermission() {
        //Mở left menu
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        //Click "QR Code Scanner"
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"QR Code Scanner\"]")).click();

        MobileUI.sleep(10);
    }
}
