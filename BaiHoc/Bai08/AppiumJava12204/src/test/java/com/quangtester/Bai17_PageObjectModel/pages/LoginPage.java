package com.quangtester.Bai17_PageObjectModel.pages;

import com.quangtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Dùng app Taurus
public class LoginPage {
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

    //Nút Menu ở dưới thanh bottom tab
    @AndroidFindBy(accessibility = "Menu")
    @iOSXCUITFindBy(accessibility = "Menu")
    private WebElement menuHome;

    //Các hàm xử lý trong chính nội bộ trang này (màn hình này)
    //Thực hiện nhập username & password
    public void login(String username , String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    //Verìy đăng nhập thành công
    public void verifyLoginSuccess() {
        Assert.assertTrue(menuHome.isDisplayed(),"The Table page not display. (Menu not found)");
    }

    //Verìy đăng nhập thất bại
    public void verifyLoginFail() {
        Assert.assertTrue(errorMessage.isDisplayed(), "The error message not display.");
        System.out.println(errorMessage.getAttribute("content-desc"));
        Assert.assertEquals(errorMessage.getAttribute("content-desc"), " Invalid email or password", "The content of error message not display.");
    }
}
