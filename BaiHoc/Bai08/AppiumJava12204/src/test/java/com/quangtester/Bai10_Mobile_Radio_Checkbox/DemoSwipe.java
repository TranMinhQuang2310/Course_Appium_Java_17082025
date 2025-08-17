package com.quangtester.Bai10_Mobile_Radio_Checkbox;

import com.quangtester.common.BaseTestTaurus;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class DemoSwipe extends BaseTestTaurus {
    //Vuốt từ dưới lên trên
    public void swipe(int startX , int startY , int endX , int endY , int durationMillis) {
        //PointerInput: Đại diện cho một thiết bị đầu vào, trong trường hợp này là ngón tay (PointerInput.Kind.TOUCH)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Sequence: Tập hợp các hành động được thực hiện bởi một PointerInput (1 ngón tay)
        Sequence swipe = new Sequence(finger, 1);
        //createPointerMove(): Di chuyển con trỏ đến vị trí của phần tử
        //PointerInput.Origin.viewport() xác định hệ tọa độ dựa trên viewport (khung nhìn) của ứng dụng.
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        //createPointerDown(): Mô phỏng việc chạm vào màn hình.
        swipe.addAction(finger.createPointerDown(0));
        //durationMillis : tốc độ vuốt
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis), PointerInput.Origin.viewport(), endX, endY));
        //createPointerUp(): Mô phỏng việc nhấc ngón tay khỏi màn hình
        swipe.addAction(finger.createPointerUp(0));
        //DriverManager.perform(): Thực hiện chuỗi hành động được định nghĩa trong Sequence.
        DriverManager.getDriver().perform(Collections.singletonList(swipe));
    }

    //Vuốt qua bên trái
    public void swipeLeft() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.2);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    //Vuốt qua bên phải
    public void swipeRight() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        //int startY = size.height / 2; // Ở chính giữa màn hình
        int startY = (int) (size.height * 0.3); // 1/3 bên trên màn hình
        int endX = (int) (size.width * 0.8);
        int endY = startY; // Giữ nguyên độ cao
        int duration = 200;

        swipe(startX, startY, endX, endY, duration);
    }

    @Test
    public void demoSwipeMenuDownToUp() {
        loginTaurusApp();
        downloadDataFromServer(1);

        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Menu")).click();
        MobileUI.sleep(4);

        //Thực hiện scoll danh sách từ dưới lên trên
        //startX = endX => vì lúc scroll lên thì chiều ngang giữ cố định
        swipe(671,1956,671,1229,500);

        MobileUI.sleep(3);
    }

    @Test
    public void demoSwipeCalendarLeft_Righ_DungToaDo() {
        loginTaurusApp();

        //Click vô "Date" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Date")).click();
        MobileUI.sleep(4);

        //Vuốt từ trái qua phải
        swipe(95, 1032, 1255, 1032, 200);
        MobileUI.sleep(3);
        //Vuốt từ phải qua trái
        swipe(1255, 1032, 95, 1032, 200);

        MobileUI.sleep(3);
    }

    @Test
    public void demoSwipeCalendarLeft_Right() {
        loginTaurusApp();

        //Click vô "Date" ở dưới bottom tab
        DriverManager.getDriver().findElement(AppiumBy.accessibilityId("Date")).click();
        MobileUI.sleep(4);

        //Vuốt qua trái
        swipeLeft();
        MobileUI.sleep(2);
        //Vuốt qua phải
        swipeRight();
        MobileUI.sleep(2);
    }

}
