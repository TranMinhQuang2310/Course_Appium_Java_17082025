package com.quangtester.Bai23_Excel_File;

import com.quangtester.DataProviders.DataProviderFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DemoDataProvider {
    // Sử dụng DataProvider với các tham số cố định
    // Sử dụng trong tại class này
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"user1", "pass1", 123},
                {"user2", "pass2", 345},
                {"user3", "pass3", 567}
        };
    }

    // Sử dụng DataProvider với các tham số cố định
    // Sử dụng trong tại class này
    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][]{
                {"customer_name", "phone", 10, "address"},
                {"customer_name2", "phone2", 20, "address2"},
                {"customer_name3", "phone3", 30, "address3"},
                {"customer_name4", "phone4", 40, "address4"},
                {"customer_name5", "phone5", 50, "address5"}
        };
    }

    //Gọi thuộc tính dataProvider trên @Test
    //Lấy tham số từ name chứ không phải tên hàm
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, int id) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("ID: " + id);

        // Thực hiện thao tác test login ở đây...
    }

    @Test(dataProvider = "customerData")
    public void customerTest(String customerName, String phone, int id, String address) {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + id);
        System.out.println("Address: " + address);

        // Thực hiện thao tác test login ở đây...
    }

    //--------------------------------------------------------------------
    //Gọi các hàm ở file DataProviderFactory

    @Test(dataProvider = "loginSuccess", dataProviderClass = DataProviderFactory.class)
    public void testLogin(String username, String password) {
        System.out.println("Login with: " + username + " - " + password);
    }

    //Đọc hết data trong một Sheet của file Excel
    @Test(dataProvider = "login_from_excel", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcel(String username, String password) {
        System.out.println("Login with: " + username + " - " + password);
    }

    //Đọc data theo vị trí dòng được set (bắt đầu - kết thúc) chỉ định trong 1 sheet
    @Test(dataProvider = "login_from_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelHashtable(Hashtable<String, String> data) {
        System.out.println("Login with: " + data.get("USERNAME") + " - " + data.get("PASSWORD"));
    }

    // Đọc data theo vị trí dòng được chọn trong 1 sheet (Cách 1)
    // => Sử dụng DataProvider với các dòng cụ thể cố định (2, 4)
    @Test(dataProvider = "login_specific_rows", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithSpecificRows(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    // Đọc data theo vị trí dòng được chọn trong 1 sheet (Cách 2)
    // => Sử dụng DataProvider với các dòng cụ thể dạng Hashtable
    @Test(dataProvider = "login_specific_rows_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithSpecificRowsHashtable(Hashtable<String, String> data) {
        String username = data.get("USERNAME");
        String password = data.get("PASSWORD");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    // Sử dụng DataProvider động với tham số từ testng.xml
    // Chạy trong file : Bai23_Suite_DataProvider_Params.xml
    @Test(dataProvider = "dynamic_rows", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithDynamicRows(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }

    // Sử dụng DataProvider động dạng Hashtable với tham số từ testng.xml
    // Chạy trong file : Bai23_Suite_DataProvider_Params.xml
    @Test(dataProvider = "dynamic_rows_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithDynamicRowsHashtable(Hashtable<String, String> data) {
        String username = data.get("USERNAME");
        String password = data.get("PASSWORD");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }
}
