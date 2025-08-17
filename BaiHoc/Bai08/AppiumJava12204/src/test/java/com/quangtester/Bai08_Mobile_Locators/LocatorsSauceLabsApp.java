package com.quangtester.Bai08_Mobile_Locators;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

//Học về xác định locator
public class LocatorsSauceLabsApp extends BaseTestSauceLabs {
    @Test
    public void testDemoLocators() {
        //Tìm title "Products"
        //Cách 1 : Dùng id
        WebElement headerPage1 = DriverManager.getDriver().findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV"));
        System.out.println("Header 1: " + headerPage1.getText());

        //Cách 2 : Dùng accessibilityId
        WebElement headerPage2 = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("title"));
        System.out.println("Header 2: " + headerPage2.getText());

        //-----------------------------------------------------------------------

        //Tìm title của sản phẩm 1 :  "Sauce Labs Backpack"
        //Cách 1 : Dùng xpath
        WebElement productName1 = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]"));
        System.out.println("Prodcut 1:" + productName1.getText());

        //Cách 2 : Dùng android uiautomator
        WebElement productName2 = DriverManager.getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        System.out.println("Product 2:" + productName2.getText());

        //-----------------------------------------------------------------------

        //Click vào sản phẩm 1 : "Sauce Labs Backpack"
        DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Product Image\"])[1]")).click();
        MobileUI.sleep(1);

        //Click Add to cart
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();
        MobileUI.sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();
        MobileUI.sleep(1);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Tap to add product to cart")).click();

    }

    @Test
    public void testXpathAxes_Buoi02() {
        //Tìm product thứ 2
        WebElement productName2 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[2]/android.widget.TextView[1]"));
        System.out.println("Product 2: " + productName2.getText());

        //Tìm giá product thứ 2
        WebElement productPrice2 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        System.out.println("Price Product 2: " + productPrice2.getText());

        //Tìm product thứ 3
        WebElement productName3 = DriverManager.getDriver().findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[3]/android.widget.TextView[1]"));
        System.out.println("Product 3: " + productName3.getText());

        //Dùng List<WebElement> => lấy ra danh sách toàn bộ product
        List<WebElement> childsElements = DriverManager.getDriver().findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/child::*"));
        for (WebElement element : childsElements) {
            System.out.println(element);
        }
    }

    @Test
    public void testXpathAxes_Buoi03() {
        // Lấy tên sản phẩm dựa vào thuộc tính @text với giá trị "Sauce Labs Backpack"
        WebElement productName = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']"));
        String textValue = productName.getAttribute("text");
        System.out.println("Product name: " + textValue);

        System.out.println("------------------------------------");

        // Dựa vào thuộc tính @ để duyệt qua danh sách => lấy danh sách kết quả "Sauce Labs Backpack"
        List<WebElement> productTitles = DriverManager.getDriver().findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc='Product Title']"));
        for (WebElement item : productTitles) {
            System.out.println(item.getAttribute("text"));
        }

        System.out.println("------------------------------------");

        // Lấy danh sách sản phẩm dựa vào thuộc tính @contains với giá trị "Sauce Labs Backpack"
        List<WebElement> productNameContains = DriverManager.getDriver().findElements(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Sauce Labs Backpack')]"));
        for (WebElement item : productNameContains) {
            System.out.println(item.getAttribute("text"));
        }

        System.out.println("------------------------------------");

        // Không phân biệt chữ hoa , thường để tìm ra giá trị "Sauce Labs Backpack"
        WebElement productName2 = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[translate(@text,'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='sauce labs backpack']"));
        String textValue2 = productName2.getAttribute("text");
        System.out.println("Product name: " + textValue2);

        System.out.println("------------------------------------");

        // Dùng giá trị and để tìm ra kết quả "Sauce Labs Backpack"
        WebElement productName3 = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Product Title' and @text='Sauce Labs Backpack']"));
        String textValue3 = productName3.getAttribute("text");
        System.out.println("Product name: " + textValue3);
    }

    @Test
    public void testXpathAxes_Buoi04() {
        //Lấy phần tử tổ tiên (ancestor)
        //Dùng ancestor để tìm ra danh sách chứa bao nhiêu phần tử
        List<WebElement> ancestorProductName = DriverManager.getDriver().findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]/ancestor::android.view.ViewGroup"));
        int countSize = ancestorProductName.size();
        System.out.println("Total Ancestor of Product Name: " + countSize);

        //Lấy phần tử con và cháu (descendant)
        //Dùng descendant để tìm ra danh sách có bao nhiêu thẻ có icon sao :
        List<WebElement> descendantProductName = DriverManager.getDriver().findElements(AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Scrollview manages views in given screen size\"]/descendant::android.view.ViewGroup[@resource-id='com.saucelabs.mydemoapp.android:id/rattingV']"));
        int countStar = descendantProductName.size();
        System.out.println("Total Descendant of Product Name: " + countStar);

        //Lấy phần tử anh chị em bên dưới (following-sibling) => chỉ tìm liền kề so với phần tử gốc
        //Dùng following-sibling để tìm $29.99
        WebElement followingSiblingProductName = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Product Title\" and @text=\"Sauce Labs Backpack\"]/following-sibling::android.widget.TextView"));
        System.out.println("Result of following-sibling : " + followingSiblingProductName.getText());

        //Lấy phần tử anh chị em bên trên (preceding-sibling) => chỉ tìm liền kề so với phần tử gốc
        //Dùng preceding-sibling để tìm title sản phẩm "Sauce Labs Backpack"
        WebElement precedingSiblingProductName = DriverManager.getDriver().findElement(AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"Product Price\"])[1]/preceding-sibling::android.widget.TextView"));
        System.out.println("Result of preceding-sibling : " + precedingSiblingProductName.getText());
    }
}
