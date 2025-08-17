package com.quangtester.Bai23_Excel_File.testcases;

import com.quangtester.Bai23_Excel_File.pages.LoginPage;
import com.quangtester.common.Bai23_BaseTest_Json_Device_Excel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestUsing_Excel_DataProvider extends Bai23_BaseTest_Json_Device_Excel {
    //Khai báo các đối tượng Page class liên quan
    private LoginPage loginPage;

    // Sử dụng DataProvider với các tham số cố định
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"admin", "admin"},
                {"user2", "pass2"},
//                {"user3", "pass3"}
        };
    }

    //Gọi thuộc tính dataProvider trên @Test => Viết hàm login
    @Test(dataProvider = "loginData")
    public void loginTestDataProvider(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Thực hiện thao tác test login ở đây...

        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Gọi hàm từ Page class sử dụng
        loginPage.login(username, password);
        loginPage.verifyLoginSuccess();
    }
}
