package com.quangtester.Bai23_Excel_File;

import com.quangtester.constants.ConfigData;
import com.quangtester.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class DemoExcelFile {
    @Test
    public void testReadExcelFile() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        //Khai báo đường dẫn đến file Excel => Xác định tên sheet muốn lấy data
        excelHelpers.setExcelFile(ConfigData.EXCEL_DATA_FILE_PATH, "Login");

        System.out.println("USERNAME: " + excelHelpers.getCellData(1, "USERNAME"));
        System.out.println("PASSWORD: " + excelHelpers.getCellData(1, "PASSWORD"));

        System.out.println("USERNAME: " + excelHelpers.getCellData(2, "USERNAME"));
        System.out.println("PASSWORD: " + excelHelpers.getCellData(2, "PASSWORD"));

    }

    //Ghi data vào file Excel
    //(*) Nhớ trước khi run phải clear data ở cột "EXPECTED_RESULT" => thì mới truyền passed/failed vô được
    @Test
    public void testWriteExcelFile() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        //Khai báo đường dẫn đến file Excel => Xác định tên sheet muốn lấy data
        excelHelpers.setExcelFile(ConfigData.EXCEL_DATA_FILE_PATH, "Login");

        //Passed => giá trị truyền vô
        //1 => Tên dòng
        //EXPECTED_RESULT => vị trí cột
        excelHelpers.setCellData("Passed", 1, "EXPECTED_RESULT");
        excelHelpers.setCellData("Failed", 2, "EXPECTED_RESULT");
    }
}
