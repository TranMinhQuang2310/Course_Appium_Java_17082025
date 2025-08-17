package com.quangtester.Bai26_GhiLogBangLog4j2.pages;

import com.quangtester.Bai26_GhiLogBangLog4j2.pages.MenuPage;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.Bai26_MobileUI_UsingLogUtils;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Dùng app Taurus
public class LoginPage extends BasePage {
    // Constructor (Cấu hình mặc định của appium)
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    //Element/Locators thuộc chính trang này (màn hình này)
    //Trường username
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "username")
    private WebElement usernameField;

    //Trường password
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElement passwordField;

    //Nút Sign in
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    @iOSXCUITFindBy(id = "loginBtn")
    private WebElement loginButton;

    //Alert thông báo sai email or password
    @AndroidFindBy(accessibility = " Invalid email or password")
    @iOSXCUITFindBy(accessibility = " Invalid email or password")
    private WebElement errorMessage;

    //Các hàm xử lý trong chính nội bộ trang này (màn hình này)
    //Thực hiện nhập username & password => Trả về trang cần liên kết đến sau khi login thành công,
        // là trang MenuPage
    public MenuPage login(String username , String password) {
        Bai26_MobileUI_UsingLogUtils.clickElement_UseWebElement_NoSetTimeout(usernameField); // Click vào username field
        Bai26_MobileUI_UsingLogUtils.setText_UseWebElement_NoSetTimeout(usernameField,username); // Nhập username
        Bai26_MobileUI_UsingLogUtils.clickElement_UseWebElement_NoSetTimeout(passwordField); // Click vào password field
        Bai26_MobileUI_UsingLogUtils.setText_UseWebElement_NoSetTimeout(passwordField,password); // Nhập password
        Bai26_MobileUI_UsingLogUtils.clickElement_UseWebElement_NoSetTimeout(loginButton); // Click nút login

        return new MenuPage();
    }

    //Verìy đăng nhập thành công
    public MenuPage verifyLoginSuccess() {
        // Sử dụng MobileUI để verify
        Bai26_MobileUI_UsingLogUtils.verifyElementPresentAndDisplayed_UseWebElement(menuMenu,"The Table page not display. (Menu not found)");

        return new MenuPage();
    }

    //Verìy đăng nhập thất bại
    public void verifyLoginFail() {
        Bai26_MobileUI_UsingLogUtils.verifyElementPresentAndDisplayed_UseWebElement(errorMessage,"The error message not display.");
        System.out.println(Bai26_MobileUI_UsingLogUtils.getElementAttribute_UseWebElement_NoSetTimeout(errorMessage,"content-desc"));
        Bai26_MobileUI_UsingLogUtils.verifyElementAttribute_UseWebElement(errorMessage,"content-desc"," Invalid email or password", "The content of error message not display.");
    }
}
