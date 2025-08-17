package com.quangtester.Bai16_Waits_Appium2x;

import com.quangtester.common.Bai16_BaseTest_ExplicitWaits;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait extends Bai16_BaseTest_ExplicitWaits {
    @Test
    public void testExplicitWait() {
        //Khai báo đối tượng wait thuộc WebDriverWait (Explicit)
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("View menu")));
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("View menu")).click();

        //Chờ hiển thị text "Login Menu Item"
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Login Menu Item")));
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Login Menu Item")).click();

        //Wait header present trước khi kểm tra displayed
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV")));

        //Chờ title Login có hiển thị không
        WebElement headerLoginPage = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));
        Assert.assertTrue(headerLoginPage.isDisplayed());
        String headerLoginText = headerLoginPage.getText();
        System.out.println("headerLoginText: " + headerLoginText);

        //Check verìy title  có phải chữ Login không
        Assert.assertEquals(headerLoginText, "Login");

        //Khai báo wait thứ 2 để setup lại thời gian khác wait trước
        WebDriverWait wait2 = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        //Wait email locator visible trước khi thao tác điền email
        wait2.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/loginTV\"]")));

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
