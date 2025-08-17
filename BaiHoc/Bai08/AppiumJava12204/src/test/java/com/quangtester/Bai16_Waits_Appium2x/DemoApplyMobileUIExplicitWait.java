package com.quangtester.Bai16_Waits_Appium2x;

import com.quangtester.common.Bai16_BaseTest_ExplicitWaits;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Sử dụng các hàm bên WebUI để chạy
public class DemoApplyMobileUIExplicitWait extends Bai16_BaseTest_ExplicitWaits {
    @Test
    public void testExplicitWait() {
        //Chờ hiển thị nút chọn "View menu"
//        MobileUI.waitForElementToBeClickable(AppiumBy.accessibilityId("View menu"),4);
//        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();

        MobileUI.clickElement_UseByLocator_setTimeout(AppiumBy.accessibilityId("View menu"),4);

        //Chờ hiển thị nút "Login Menu Item"
//        MobileUI.waitForElementVisible(AppiumBy.accessibilityId("Login Menu Item"),5);
//        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();
        MobileUI.clickElement_UseByLocator_setTimeout(AppiumBy.accessibilityId("Login Menu Item"),5);

        //Chờ title Login có hiển thị không
        MobileUI.waitForElementVisible_UseByLocator_setTimeout(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"), 5);
        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        //Check verìy title  có phải chữ Login không
        Assert.assertEquals(headerLoginText, "Login");

        //Khai báo wait thứ 2 để setup lại thời gian khác wait trước
        MobileUI.waitForElementVisible_UseByLocator_setTimeout(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]"), 10);

        //Thực hiện các bước nhập username / password
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")).sendKeys("bod@example.com");
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).clear();
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")).sendKeys("10203040");
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to login with given credentials")).click();
        MobileUI.sleep(2);

        //Check title Product có hiển thị không
        WebElement headerCatalogPage = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        Assert.assertTrue(headerCatalogPage.isDisplayed());
        String headerCatalogText = headerCatalogPage.getText();
        System.out.println("headerCatalogText: " + headerCatalogText);

        //Check verìy title có phải chữ Product không
        Assert.assertEquals(headerCatalogText, "Products");

        System.out.println("Login success.");

    }
}
