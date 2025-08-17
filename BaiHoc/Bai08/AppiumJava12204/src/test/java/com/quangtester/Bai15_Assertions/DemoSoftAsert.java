package com.quangtester.Bai15_Assertions;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Soft Assert cho phép bài kiểm thử tiếp tục chạy ngay cả khi một assertion thất bại.
//Sau khi tất cả các assertion được thực thi, chúng ta cần gọi assertAll() để báo cáo lỗi.

public class DemoSoftAsert extends BaseTestSauceLabs {
    @Test(priority = 1)
    public void testLoginSuccess() {
        //Khai báo đối tượng class
        SoftAssert softAssert = new SoftAssert();

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        //Check title Login có hiển thị không
        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        softAssert.assertFalse(headerLoginPage.isDisplayed(),"Header Login Page không hiển thị");
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        //Check verìy title  có phải chữ Login không
        //Để Login123 để báo lỗi
        softAssert.assertEquals(headerLoginText,"Login123","Login Header Text not match");

        //Thực hiện các bước nhập username / password
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        //Check title Product có hiển thị không
        WebElement headerCatalogPage = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        softAssert.assertTrue(headerCatalogPage.isDisplayed());
        String headerCatalogText = headerCatalogPage.getText();
        System.out.println("headerCatalogText: " + headerCatalogText);

        //Check verìy title có phải chữ Product không
        softAssert.assertEquals(headerCatalogText, "Products");

        System.out.println("Login success.");

        //Gọi assertAll() để báo cáo lỗi
        softAssert.assertAll();

    }

}
