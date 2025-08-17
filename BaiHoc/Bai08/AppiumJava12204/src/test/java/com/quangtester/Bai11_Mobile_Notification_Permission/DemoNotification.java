package com.quangtester.Bai11_Mobile_Notification_Permission;

import com.quangtester.common.BaseTestAndroidPlatform;
import com.quangtester.drivers.AndroidDriverManager;
import com.quangtester.drivers.DriverManager;
import com.quangtester.keywords.MobileUI;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

//Học về check Notify được push tới
public class DemoNotification extends BaseTestAndroidPlatform {
    @Test
    public void testHandleNotification() {
        //Mở phần thông báo bên trên cuộn xuống
        AndroidDriverManager.getDriver().openNotifications();

        //Get các tiêu đề của thông báo
        List<WebElement> notifications = AndroidDriverManager.getDriver().findElements(AppiumBy.id("android:id/title"));
        System.out.println("Danh sách tiêu đề trong thông báo: ");
        for(WebElement notification : notifications) {
            System.out.println(notification.getText());
        }

        MobileUI.sleep(2);

        //Get các mô tả của thông báo
        List<WebElement> descriptions = AndroidDriverManager.getDriver().findElements(AppiumBy.id("android:id/text"));
        System.out.println("Danh sách mô tả trong thông báo: ");

        for(WebElement description : descriptions) {
            try {
                String descriptionText = description.getText();
                System.out.println(descriptionText);
            } catch (NoSuchElementException e) {
                System.out.println("*** Không tìm thấy phần mô tả cho thông báo này (hoặc không có mô tả).");
            }
        }

        //Đóng phần Notification
        //Cách 1:
        AndroidDriverManager.getDriver().navigate().back();

        //Cách 2 : Dùng swipe theo toạ độ
        //swipe(542, 2186, 542, 300, 200);

        MobileUI.sleep(3);
    }

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
        //AndroidDriverManager.perform(): Thực hiện chuỗi hành động được định nghĩa trong Sequence.
        AndroidDriverManager.getDriver().perform(Collections.singletonList(swipe));
    }
}
