package com.quangtester.Bai20_Multiple_Platform.pages;

import com.quangtester.common.Bai20_BaseTestDungBai20VaBai21;
import com.quangtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Bai20_BaseTestDungBai20VaBai21 {
    // Constructor (Cấu hình mặc định của appium)
    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    //Element/Locators thuộc chính trang này (màn hình này)
    //Nút Edit Profile
    @AndroidFindBy(accessibility = "Edit profile")
    @iOSXCUITFindBy(accessibility = "Edit profile")
    private WebElement buttonEditProfile;

    public void editProfile() {
        System.out.println("Edit Profile");
        buttonEditProfile.click();
    }
}
