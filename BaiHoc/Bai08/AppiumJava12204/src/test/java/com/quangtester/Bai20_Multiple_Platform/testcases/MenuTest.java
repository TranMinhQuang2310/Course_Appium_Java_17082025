package com.quangtester.Bai20_Multiple_Platform.testcases;

import com.quangtester.Bai20_Multiple_Platform.pages.LoginPage;
import com.quangtester.Bai20_Multiple_Platform.pages.MenuPage;
import com.quangtester.common.Bai20_BaseTestDungBai20VaBai21;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class MenuTest extends Bai20_BaseTestDungBai20VaBai21 {
    LoginPage loginPage;
    MenuPage menuPage;

    //Thực hiện chức năng tìm kiếm
    @Test
    public void testSearchTable() {
        loginPage = new LoginPage();
        //Khởi tạo trang MenuPage thông qua việc Login nếu thành công
        menuPage = loginPage.login("admin", "admin");
        loginPage.verifyLoginSuccess();

        //Download data
        downloadDataFromServer(4);

        //Nhập dữ liệu vào thanh search
        //menuPage = new MenuPage(); //không cần khởi tạo trang Menu riêng
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
