package com.quangtester.testcases;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.drivers.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//Kế thừa các hàm của class BaseTest.java
public class TaurusAppTest extends BaseTestSauceLabs {
    @Test
    public void testLoginTaurusApp() {
        // Tìm và tương tác với các phần tử giao diện
        // Nhập email
        WebElement inputEmail = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText)[1]"));
        inputEmail.click();
        inputEmail.sendKeys("admin");

        // Nhập password
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText)[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");

        // Nhấn nút "Sign in"
        WebElement signInButton = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Sign in"));
        signInButton.click();

        // Đợi sau khi nhấn nút Sign in
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Kiểm tra kết quả đăng nhập
        // Ví dụ: Tìm kiếm một phần tử chỉ xuất hiện khi đăng nhập thành công
        // Kiểm tra nút "Menu" có hiển thị không
        WebElement menuElement = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        if (menuElement.isDisplayed()) {
            System.out.println("Login thành công!");
        } else {
            System.out.println("Login thất bại!");
        }
    }
}