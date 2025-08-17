package com.quangtester.Bai22_JSON_File;

import com.quangtester.helpers.JsonHelpers;
import org.testng.annotations.Test;

//Đọc data từ file JSON
public class DemoJsonFile {
    //VD1 : Đọc data từ file JSON
    @Test
    public void testReadJsonFile() {
        //Get value from JSON object (từ file data.json)
        JsonHelpers.getValueJsonObject("platform");
        JsonHelpers.getValueJsonObject("device");

        JsonHelpers.getValueJsonObject("account", "username");
        JsonHelpers.getValueJsonObject("account", "password");

        System.out.println("-------------------------------------------------");

        JsonHelpers.getValueJsonObject("table", "table_name");

        System.out.println("-------------------------------------------------");

        JsonHelpers.getValueJsonObject("product", "product_name");
        JsonHelpers.getValueJsonObject("product", "product_price");
        JsonHelpers.getValueJsonObject("product", "hidden_product");
        JsonHelpers.getValueJsonObject("product", "product_image");

        System.out.println("-------------------------------------------------");

        //(từ file device.json)
        JsonHelpers.getValueJsonObject_FilePath("src/test/resources/configs/device.json", "platforms", "android", "devices", "pixel3a", "deviceName");

        System.out.println("-------------------------------------------------");

        //Get value from JSON array (từ file sample_products.json)
        //index : là vị trí của object trong array => Ở đây get object đầu tiên trong mảng
        JsonHelpers.getValueJsonArray_FilePath("src/test/resources/test_data/sample_products.json", 0, "price", "amount");
    }

    //VD2 : Ghi data và cập nhật data vào JSON file
    /*
        Chỗ này các hàm updateValueJson đã viết sẵn 2 trường hợp:
        Cập nhật giá trị nếu key đã tồn tại (update)
        Add key mới cùng giá trị mới nếu key chưa tồn tại (add)
    */
    @Test
    public void testUpdateValueToJsonFile() {
        //Add new data with root key value (từ file data.json)
        JsonHelpers.updateValueJsonObject(
                "database_name", "Data 4");
        JsonHelpers.updateValueJsonObject(
                "database_index", 4);

        //Add new data with parent key is object (từ file data.json)
        JsonHelpers.updateValueJsonObject("database",
                "database_name", "Data 1");
        JsonHelpers.updateValueJsonObject("database",
                "database_index", 1);

        //Update value with parent key is object in file path (từ file data.json)
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "product", "product_name", "Product 3");
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "product", "product_price", 140000);

        //Add new data with parent key is object in file path (từ file data.json)
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "profile", "name", "Anh Tester");
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "profile", "email", "anhtester@example.com");
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "profile", "phone", "0939206009");
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "profile", "address", "HCM");
        JsonHelpers.updateValueJsonObject_FilePath("src/test/resources/test_data/data.json",
                "profile", "job_title", "Tester");

        //Update value in JSON array (từ file sample_products.json)
        //index : là vị trí của object trong array => Ở đây update  object thứ 2 trong mảng
        JsonHelpers.updateValueJsonArray_FilePath("src/test/resources/test_data/sample_products.json", "24Gb", 1, "specs", "ram");
    }
}
