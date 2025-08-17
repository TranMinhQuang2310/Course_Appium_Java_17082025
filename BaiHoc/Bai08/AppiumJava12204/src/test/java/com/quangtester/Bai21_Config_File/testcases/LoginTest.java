package com.quangtester.Bai21_Config_File.testcases;

import com.quangtester.Bai21_Config_File.pages.LoginPage;
import com.quangtester.common.Bai20_BaseTestDungBai20VaBai21;
import org.testng.annotations.Test;

public class LoginTest extends Bai20_BaseTestDungBai20VaBai21 {
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
