package com.quangtester.Bai26_GhiLogBangLog4j2.testcases;

import com.quangtester.Bai26_GhiLogBangLog4j2.pages.LoginPage;
import com.quangtester.common.Bai22_BaseTest_Json_Device;
import com.quangtester.common.Bai24_BaseTest_Listeners;
import com.quangtester.common.Bai25_BaseTest_Screenshot_RecordVideo;
import com.quangtester.common.Bai26_BaseTest_GhiLogBangLog4j2;
import com.quangtester.helpers.CaptureHelpers;
import org.testng.annotations.Test;

public class LoginTest extends Bai26_BaseTest_GhiLogBangLog4j2 {
    //Khai báo các đối tượng Page class liên quan
    private LoginPage loginPage;

    //Thực hiện chức năng đăng nhập thành công
    @Test
    public void testLoginSuccess() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Gọi hàm từ Page class sử dụng
        loginPage.login("admin", "admin");

        loginPage.verifyLoginSuccess();
    }

    //Thực hiện chức năng đăng nhập thất bại
    @Test
    public void testLoginFailWithUsernameInvalid() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Gọi hàm từ Page class sử dụng
        loginPage.login("admin123", "admin");

        loginPage.verifyLoginFail();
    }
}
