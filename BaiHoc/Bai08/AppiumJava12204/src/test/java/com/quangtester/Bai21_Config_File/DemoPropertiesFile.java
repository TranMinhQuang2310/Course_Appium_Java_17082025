package com.quangtester.Bai21_Config_File;

import com.quangtester.helpers.PropertiesHelpers;
import org.testng.annotations.Test;

//Gọi giá trị từ file "config.properties" thông qua class : PropertiesHelpers
//Run file này sau đó vô đường dẫn "src/test/resources/test_data/data.properties" để kiểm tra
public class DemoPropertiesFile {
    @Test
    public void testReadPropertiesFile() {
        PropertiesHelpers.loadAllFiles();

        System.out.println(PropertiesHelpers.getValue("APPIUM_DRIVER_LOCAL_SERVICE"));
        System.out.println(PropertiesHelpers.getValue("TIMEOUT_SERVICE"));
        System.out.println(PropertiesHelpers.getValue("TIMEOUT_EXPLICIT_DEFAULT"));
        System.out.println(PropertiesHelpers.getValue("JSON_CONFIG_FILE_PATH"));
    }

    @Test
    public void testSetValueToPropertiesFile() {
        PropertiesHelpers.setValue(
                "src/test/resources/test_data/data.properties",
                "PLATFORM",
                "iOS");

        PropertiesHelpers.setValue(
                "src/test/resources/test_data/data.properties",
                "DEVICE",
                "Pixel 3a");

        PropertiesHelpers.removeKey("src/test/resources/test_data/data.properties",
                "platform");
        PropertiesHelpers.removeKey("src/test/resources/test_data/data.properties",
                "device");
    }
}
