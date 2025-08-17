package com.quangtester.Bai09_Mobile_AutomationMethods;

import com.quangtester.common.BaseTestTaurus;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoInputButton_Taurus extends BaseTestTaurus {
    @Test
    public void testLoginTaurusApp() {
        MobileUI.sleep(2);
        WebElement inputUsername = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]"));
        inputUsername.click();
        inputUsername.sendKeys("admin");
        MobileUI.sleep(1);
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")).click();

        MobileUI.sleep(2);
        WebElement menuMenu = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        //Kiểm tra có xuất hiện nút "Menu"
        if(menuMenu.isDisplayed()) {
            System.out.println("Login success");
        }else{
            System.out.println("Login failed");
        }
    }
}
