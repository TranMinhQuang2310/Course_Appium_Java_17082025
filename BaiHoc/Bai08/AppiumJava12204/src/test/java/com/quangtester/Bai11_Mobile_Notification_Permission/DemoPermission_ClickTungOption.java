package com.quangtester.Bai11_Mobile_Notification_Permission;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class DemoPermission_ClickTungOption extends BaseTestSauceLabs {
    @Test
    public void testAcceptPermission() {
        //Mở left menu
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        //Click "QR Code Scanner"
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"QR Code Scanner\"]")).click();

        //Mở 1 trong 3 option
        //DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button")).click();
        //DriverManager.getDriver().findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();

        MobileUI.sleep(10);

    }
}
