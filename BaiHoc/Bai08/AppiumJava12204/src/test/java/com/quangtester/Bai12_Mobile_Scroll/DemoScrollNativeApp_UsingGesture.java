package com.quangtester.Bai12_Mobile_Scroll;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class DemoScrollNativeApp_UsingGesture extends BaseTestSauceLabs {
    //Scroll từ dưới lên trên (Dùng Getsure)
    @Test
    public void testScrollUsingMobileCommand() {
        MobileUI.scrollGestureCommand();
        MobileUI.scrollGestureCommand();
        MobileUI.scrollGestureCommand();
    }

}
