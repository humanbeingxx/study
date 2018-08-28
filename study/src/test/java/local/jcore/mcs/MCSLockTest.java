package local.jcore.mcs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/8/28 下午4:50
 **/
public class MCSLockTest {

    private MCSLock lock;

    @BeforeMethod
    public void initLock() {
        lock = new MCSLock();
    }

    @Test
    public void test() throws InterruptedException {
        List<Integer> data = Lists.newArrayList();

        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                    System.out.println("try lock " + Thread.currentThread().getName());
                    lock.lock();
                    System.out.println("get lock " + Thread.currentThread().getName());
                    data.add(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }

        Thread.sleep(100);
        lock.lock();
        assertEquals(data.size(), 200);
        lock.unlock();
    }

}