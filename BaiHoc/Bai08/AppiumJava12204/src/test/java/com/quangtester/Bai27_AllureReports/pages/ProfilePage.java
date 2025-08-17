package com.quangtester.Bai27_AllureReports.pages;

import com.quangtester.common.Bai22_BaseTest_Json_Device;
import com.quangtester.common.Bai25_BaseTest_Screenshot_RecordVideo;
import com.quangtester.common.Bai26_BaseTest_GhiLogBangLog4j2;
import com.quangtester.common.Bai27_BaseTest_Using_Log4j2_AllureReports;
import com.quangtester.drivers.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Bai27_BaseTest_Using_Log4j2_AllureReports {
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
