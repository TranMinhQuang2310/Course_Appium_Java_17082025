package com.quangtester.Bai19_HamXuLyChung.testcases;

import com.quangtester.Bai19_HamXuLyChung.pages.LoginPage;
import com.quangtester.Bai19_HamXuLyChung.pages.MenuPage;
import com.quangtester.common.BaseTestTaurusOfficial;
import org.testng.annotations.Test;

public class MenuTest extends BaseTestTaurusOfficial {
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
        downloadDataFromServer(2);

        //Nhập dữ liệu vào thanh search
        //menuPage = new MenuPage(); //không cần khởi tạo trang Menu riêng
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
