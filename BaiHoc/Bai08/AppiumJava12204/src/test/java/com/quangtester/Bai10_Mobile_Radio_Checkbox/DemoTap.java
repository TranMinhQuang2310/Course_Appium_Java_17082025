package com.quangtester.Bai10_Mobile_Radio_Checkbox;

import com.quangtester.common.BaseTestTaurus;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

//Học về tap (nhấn vào)
public class DemoTap extends BaseTestTaurus {

    //Khai báo Point để chia màn hình làm 1/2
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(
                location.getX() + size.getWidth() / 2 ,
                location.getY() + size.getHeight() / 2
        );
    }

    //Tap vào element
    public void tapElement(WebElement element) {
        //Lấy tọa độ của phần tử trên màn hình
        Point locaiton = element.getLocation();
        //Lấy kích thước màn hình
        Dimension size = element.getSize();
        //Áp dụng công thức ở hàm "getCenterOfElement" để lấy được vị trí chính giữa màn hình
        Point centerOfElement = getCenterOfElement(locaiton,size);
        //PointerInput: Đại diện cho một thiết bị đầu vào, trong trường hợp này là ngón tay (PointerInput.Kind.TOUCH)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Sequence: Tập hợp các hành động được thực hiện bởi một PointerInput (1 ngón tay)
        Sequence sequence = new Sequence(finger,1)
                //createPointerMove(): Di chuyển con trỏ đến vị trí của phần tử
                //PointerInput.Origin.viewport() xác định hệ tọa độ dựa trên viewport (khung nhìn) của ứng dụng.
                .addAction(finger.createPointerMove(Duration.ZERO , PointerInput.Origin.viewport(), centerOfElement))
                //createPointerDown(): Mô phỏng việc chạm vào màn hình.
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                //Cho ngón tay dừng tầm 0.5s
                .addAction(new Pause(finger,Duration.ofMillis(500)))
                //createPointerUp(): Mô phỏng việc nhấc ngón tay khỏi màn hình
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        //DriverManager.perform(): Thực hiện chuỗi hành động được định nghĩa trong Sequence.
        DriverManager.getDriver().perform(Collections.singletonList(sequence));
    }

    //Tap vào toạ độ
    public void tapToaDo(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        //Cho ngón tay dừng tầm 0.2s
        tap.addAction(new Pause(finger, Duration.ofMillis(200)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(Arrays.asList(tap));
    }

    //Tap vào toạ độ với thời gian chỉ định
    public void tapToaDoTime(int x, int y, int second) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        //Chạm vào với thời gian chỉ định
        tap.addAction(new Pause(finger, Duration.ofMillis(second)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(Arrays.asList(tap));
    }

    @Test
    public void DemoTapElement() {
        loginTaurusApp();
        //Nhấn chọn "Config" ở dưới bottom tab
        WebElement menuConfig = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config"));
        MobileUI.sleep(2);
        tapElement(menuConfig);
    }

    @Test
    public void DemoTapToaDo() {
        loginTaurusApp();

        //Nhấn chọn "Config" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();
        MobileUI.sleep(2);
        //Nhấn chọn nút "Table Management" => truyền toạ độ vào
        tapToaDo(456,954);

    }

    @Test
    public void DemoTapToaDoTime() {
        loginTaurusApp();

        //Nhấn chọn "Config" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Config")).click();
        MobileUI.sleep(2);
        //Nhấn chọn nút "Table Management" => truyền toạ độ và thời gian chỉ định vào
        tapToaDoTime(456,954,2);

    }
}
