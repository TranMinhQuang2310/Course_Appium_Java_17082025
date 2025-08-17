package com.quangtester.Bai24_Listeners;

import com.quangtester.Listeners.TestListener;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Trong trường hợp chạy bằng file .xml hoặc CÓ khai báo "@Listeners(TestListener.class)" trong file testcase
//=> Command / xoá "@Listeners(TestListener.class)" trong đây đi
@Listeners(TestListener.class)
public class DemoListeners {
    @Test
    public void test1() {
        System.out.println("Test 1 running...");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 running...");
        throw new RuntimeException("Test 2 failed");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 running...");
        throw new SkipException("Test 3 skipped");
    }
}
