package com.quangtester.Bai12_Mobile_Scroll;

import com.quangtester.common.BaseTestSauceLabs;
import com.quangtester.keywords.MobileUI;
import org.testng.annotations.Test;

public class DemoScrollNativeApp_UsingW3CActionsAPI extends BaseTestSauceLabs {
    //Scroll từ dưới lên trên (Dùng W3C Actions API)
    @Test
    public void testScrollUsingW3Actions() {
        MobileUI.scroll(563, 1729, 547, 1072, 1000);
        MobileUI.scroll(563, 1729, 547, 1072, 1000);
        MobileUI.scroll(563, 1729, 547, 1072, 1000);
    }
}
