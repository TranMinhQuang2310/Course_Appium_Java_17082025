package com.quangtester.Bai23_Excel_File.testcases;

import com.quangtester.Bai23_Excel_File.pages.LoginPage;
import com.quangtester.Bai23_Excel_File.pages.MenuPage;
import com.quangtester.common.Bai20_BaseTestDungBai20VaBai21;
import com.quangtester.common.Bai22_BaseTest_Json_Device;
import com.quangtester.common.Bai23_BaseTest_Json_Device_Excel;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class MenuTest extends Bai23_BaseTest_Json_Device_Excel {
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
