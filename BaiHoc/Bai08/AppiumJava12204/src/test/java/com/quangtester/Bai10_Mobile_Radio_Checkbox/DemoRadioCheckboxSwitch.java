package com.quangtester.Bai10_Mobile_Radio_Checkbox;

import com.quangtester.common.BaseTestTaurus;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

//Học về Radio / Checkbox / Switch (bật / tắt)
public class DemoRadioCheckboxSwitch extends BaseTestTaurus {
    //Demo Switch (bật / tắt)
    @Test
    public void testAddTable() {
        loginTaurusApp();

        //Nhấn chọn "Config" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();
        //Nhấn chọn nút "Table Management"
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,'Tables management')]")).click();
        //Nhấn nút "Add Table"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Add Table")).click();

        //Kiểm tra status nút switch trước khi click (có checked chưa)
        String checkBeforeClick = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).getAttribute("checked");
        System.out.println(checkBeforeClick);
        MobileUI.sleep(1);

        //Click nút switch
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).click();
        MobileUI.sleep(1);

        //Kiểm tra status nút switch sau khi click (có checked chưa)
        String checkAfterClick = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Switch")).getAttribute("checked");
        System.out.println(checkAfterClick);


    }
}
