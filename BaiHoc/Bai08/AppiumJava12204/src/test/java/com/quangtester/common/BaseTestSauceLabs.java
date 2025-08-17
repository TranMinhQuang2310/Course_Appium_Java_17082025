package com.quangtester.common;

import com.quangtester.drivers.DriverManager;
import com.quangtester.helpers.SystemHelpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestSauceLabs {

    //Thiết lập host + port
    private AppiumDriverLocalService service;
    private String HOST = "127.0.0.2";
    private String PORT = "9000";
    private int TIMEOUT_SERVICE = 60;

    //Thiết lập Appium Server => Thay vì phải mở cmd , nhấn appium => thì set trong code luôn
    @BeforeSuite
    public void runAppiumServer() {
        //Kill process on port
        //Tắt port
        SystemHelpers.killProcessOnPort("9000");

        //Build the Appium service
        //Băt đầu khởi tạo Appium
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress(HOST);
        builder.usingPort(Integer.parseInt(PORT));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info"); // Set log level (optional)
        //Thông báo lỗi nếu quá thời gian không bật được server
        builder.withTimeout(Duration.ofSeconds(TIMEOUT_SERVICE));

        //Start the server with the builder
        //Bắt đầu chạy server
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        if (service.isRunning()) {
            System.out.println("##### Appium server started on " + HOST + ":" + PORT);
        } else {
            System.out.println("Failed to start Appium server.");
        }

    }

    //Khởi tạo driver appium và kết nối đến app trên thiết bị mobile chỉ định
    @BeforeTest
    public void setUpDriver() {
        AppiumDriver driver;
        UiAutomator2Options options = new UiAutomator2Options();

        System.out.println("***SERVER ADDRESS: " + HOST);
        System.out.println("***SERVER POST: " + PORT);

        //Thiết lập máy ảo => Thay vì dùng trên Appium Inspector => set trên code luôn
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 3a");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        options.setNoReset(false);
        options.setFullReset(false);

        try {
            driver = new AppiumDriver(new URL("http://" + HOST + ":" + PORT), options);
            DriverManager.setDriver(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //Set thời gian tối đa để tìm ra element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //Tắt driver
    @AfterTest
    public void tearDownDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
        }
        if (service != null && service.isRunning()) {
            //Thay vì phải nhấn tắt cmd để ngắt chạy appium => thì set trong code luôn
            service.stop();
            System.out.println("##### Appium server stopped.");
        }
    }

}