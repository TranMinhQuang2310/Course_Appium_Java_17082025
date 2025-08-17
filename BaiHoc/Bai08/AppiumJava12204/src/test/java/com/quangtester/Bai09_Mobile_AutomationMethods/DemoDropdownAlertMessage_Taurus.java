package com.quangtester.Bai09_Mobile_AutomationMethods;

import com.quangtester.common.BaseTestTaurus;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Học về dropdown và kiểm tra alert
public class DemoDropdownAlertMessage_Taurus extends BaseTestTaurus {
    @Test (priority = 1)
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

    @Test (priority = 2)
    public void testSortTable() {
        testLoginTaurusApp();

        //Nhấn chọn "Config" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();

        //Nhấn chọn "Server Databale"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Server database")).click();
        MobileUI.sleep(2);
        //Click icon tải xuống
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Data 1')]/android.widget.Button")).click();
        //Click nút "Replace"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Replace")).click();
        MobileUI.sleep(1);

        //Handle Alert Message, check displayed hoặc getText/getAttribute để kiểm tra nội dung message
        //Hiển thị alert thông báo thành công sau khi nhấn nút "Replace"
        if (DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Downloaded")).isDisplayed()) {
            System.out.println("Database demo downloaded.");
        }else{
            System.out.println("Warning!! Can not download Database demo.");
        }
        MobileUI.sleep(2);

        //Nhấn nút "Back"
        MobileUI.sleep(2);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Back")).click();

        //Nhấn chọn nút "Table Management"
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,\"Tables management\")]")).click();
        MobileUI.sleep(2);

        //Nhấn vào dropdown sort "By name A-Z"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("By name A-Z")).click();
        MobileUI.sleep(1);
        //Chọn "By name Z-A"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("By name Z-A")).click();
        MobileUI.sleep(1);

        //Kiểm tra giá trị đầu tiên
        WebElement firstItem = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]"));
        System.out.println("First Item : " + firstItem.getAttribute("content-desc"));
    }

}
