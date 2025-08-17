package com.quangtester.Bai26_GhiLogBangLog4j2.testcases;

import com.quangtester.Bai26_GhiLogBangLog4j2.pages.LoginPage;
import com.quangtester.Bai26_GhiLogBangLog4j2.pages.MenuPage;
import com.quangtester.common.*;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class MenuTest extends Bai26_BaseTest_GhiLogBangLog4j2 {
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
        MobileUI.sleep(2);
        downloadDataFromServer(4);

        //Nhập dữ liệu vào thanh search
        //menuPage = new MenuPage(); //không cần khởi tạo trang Menu riêng
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
