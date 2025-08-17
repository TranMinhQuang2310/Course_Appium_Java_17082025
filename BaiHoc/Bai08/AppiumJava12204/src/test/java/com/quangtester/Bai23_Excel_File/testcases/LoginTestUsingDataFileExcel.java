package com.quangtester.Bai23_Excel_File.testcases;

import com.quangtester.Bai23_Excel_File.pages.LoginPage;
import com.quangtester.common.Bai23_BaseTest_Json_Device_Excel;
import com.quangtester.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class LoginTestUsingDataFileExcel extends Bai23_BaseTest_Json_Device_Excel {
    //Khai báo các đối tượng Page class liên quan
    private LoginPage loginPage;

    //Thực hiện chức năng đăng nhập thành công
    @Test
    public void testLoginSuccess() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Lấy dữ liệu từ file Excel
        ExcelHelpers excelHelpers = new ExcelHelpers();
        String filePath = "src/test/resources/test_data/data.xlsx";
        excelHelpers.setExcelFile(filePath, "Login");
        String username = excelHelpers.getCellData(1, "USERNAME");
        String password = excelHelpers.getCellData(1, "PASSWORD");
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);

        //Gọi hàm từ Page class sử dụng
        loginPage.login(username, password);
        loginPage.verifyLoginSuccess();

        //Ghi vào file Excel sau khi run thành công
            // => phải chạy tuần tự chứ không chạy parallel được (Nên chỉ run test bình thường chứ không chạy = file xml)
        excelHelpers.setCellData("Passed",1,"EXPECTED_RESULT");
    }

    //Thực hiện chức năng đăng nhập thất bại
    @Test
    public void testLoginFailWithUsernameInvalid() {
        //Khởi tạo đối tượng Page class
        loginPage = new LoginPage();

        //Lấy dữ liệu từ file Excel
        ExcelHelpers excelHelpers = new ExcelHelpers();
        String filePath = "src/test/resources/test_data/data.xlsx";
        excelHelpers.setExcelFile(filePath, "Login");
        String username = excelHelpers.getCellData(2, "USERNAME");
        String password = excelHelpers.getCellData(2, "PASSWORD");
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);

        //Gọi hàm từ Page class sử dụng
        loginPage.login(username, password);
        loginPage.verifyLoginFail();

        //Ghi vào file Excel sau khi run thành công
        // => phải chạy tuần tự chứ không chạy parallel được (Nên chỉ run test bình thường chứ không chạy = file xml)
        excelHelpers.setCellData("Passed",2,"EXPECTED_RESULT");
    }
}
