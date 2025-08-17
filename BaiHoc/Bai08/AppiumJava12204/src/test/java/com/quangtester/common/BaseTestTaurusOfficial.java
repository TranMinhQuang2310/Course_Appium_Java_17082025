package com.quangtester.common;

import com.quangtester.drivers.DriverManager;
import com.quangtester.helpers.SystemHelpers;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestTaurusOfficial {
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
    @BeforeMethod
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
        options.setAppPackage("com.anhtester.mobile_app.taurus");
        options.setAppActivity("com.anhtester.mobile_app.taurus.MainActivity");
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
    @AfterMethod
    public void tearDownDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
            System.out.println("##### Driver quit and removed.");
        }

    }

    //Tắt server
    @AfterSuite
    public void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            //Thay vì phải nhấn tắt cmd để ngắt chạy appium => thì set trong code luôn
            service.stop();
            System.out.println("##### Appium server stopped.");
        }
    }

    //Viết hàm nghỉ 1s
    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Viết hàm Login để tái sử dụng :
    public void loginTaurusApp() {
        MobileUI.sleep(2);
        WebElement inputUsername = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[1]"));
        inputUsername.click();
        inputUsername.sendKeys("admin");
        MobileUI.sleep(1);
        WebElement inputPassword = DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Mobile App Flutter Beta\"]/following-sibling::android.widget.EditText[2]"));
        inputPassword.click();
        inputPassword.sendKeys("admin");

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")).click();

        MobileUI.sleep(2);
        WebElement menuMenu = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu"));
        //Kiểm tra có xuất hiện nút "Menu"
        if(menuMenu.isDisplayed()) {
            System.out.println("Login success");
        }else{
            System.out.println("Login failed");
        }
    }

    //Viết hàm download data từ server để tái sử dụng
    public void downloadDataFromServer(int dataNumber) {
        //Nhấn chọn "Config" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();
        //Nhấn chọn "Server Databale"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Server database")).click();
        MobileUI.sleep(2);
        //Click icon tải xuống
        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Data 1')]/android.widget.Button")).click();
        //Click nút "Replace"
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Replace")).click();
        MobileUI.sleep(1);
        //Handle Alert Message, check displayed hoặc getText/getAttribute để kiểm tra nội dung message
        //Hiển thị alert thông báo thành công sau khi nhấn nút "Replace"
        if (DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Downloaded")).isDisplayed()) {
            System.out.println("Database demo downloaded.");
        }else{
            System.out.println("Warning!! Can not download Database demo.");
        }
        MobileUI.sleep(2);
        //Nhấn nút "Back"
        MobileUI.sleep(2);
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Back")).click();
    }
}
