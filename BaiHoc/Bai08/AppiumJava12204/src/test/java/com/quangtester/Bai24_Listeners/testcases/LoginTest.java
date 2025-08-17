package com.quangtester.Bai24_Listeners.testcases;

import com.quangtester.Bai24_Listeners.pages.LoginPage;
import com.quangtester.common.Bai22_BaseTest_Json_Device;
import com.quangtester.common.Bai24_BaseTest_Listeners;
import org.testng.annotations.Test;

public class LoginTest extends Bai24_BaseTest_Listeners {
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
