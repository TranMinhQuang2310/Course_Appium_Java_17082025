package com.quangtester.Bai17_PageObjectModel.testcases;

import com.quangtester.Bai17_PageObjectModel.pages.LoginPage;
import com.quangtester.common.BaseTestTaurus;
import com.quangtester.common.BaseTestTaurusOfficial;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestTaurusOfficial {
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
