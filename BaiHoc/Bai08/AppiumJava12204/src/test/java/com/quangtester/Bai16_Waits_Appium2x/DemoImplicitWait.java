package com.quangtester.Bai16_Waits_Appium2x;

import com.quangtester.common.Bai16_BaseTest_ImplicitlyWaits;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Sử dụng cơ chế set thời gian tối đa để tìm ra element đã set ở lớp BaseTest
public class DemoImplicitWait extends Bai16_BaseTest_ImplicitlyWaits {
    @Test
    public void testImplicitWait() {
        //Set implicit wait toàn cục cho tất cả các lệnh findElement tối đa là 3 giây
        //DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        //Check title Login có hiển thị không
        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        //Check verìy title  có phải chữ Login không
        Assert.assertEquals(headerLoginText, "Login");

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
        Assert.assertEquals(headerCatalogText,"Products");

        System.out.println("Login success.");

    }
}
