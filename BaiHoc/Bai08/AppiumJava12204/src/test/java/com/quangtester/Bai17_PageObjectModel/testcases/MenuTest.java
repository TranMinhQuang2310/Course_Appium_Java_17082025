package com.quangtester.Bai17_PageObjectModel.testcases;

import com.quangtester.Bai17_PageObjectModel.pages.LoginPage;
import com.quangtester.Bai17_PageObjectModel.pages.MenuPage;
import com.quangtester.common.BaseTestTaurusOfficial;
import org.testng.annotations.Test;

public class MenuTest extends BaseTestTaurusOfficial {
    LoginPage loginPage;
    MenuPage menuPage;

    //Thực hiện chức năng tìm kiếm
    @Test
    public void testSearchTable() {
        loginPage = new LoginPage();
        loginPage.login("admin", "admin");
        loginPage.verifyLoginSuccess();

        //Download data
        downloadDataFromServer(2);

        //Nhập dữ liệu vào thanh search
        menuPage = new MenuPage();
        menuPage.searchTable("Table 1");
        menuPage.checkTableResultTotal(1);
    }
}
