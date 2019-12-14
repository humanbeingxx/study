package local.jcore;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/29 下午5:10
 **/
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    @Test
    public void test() throws InterruptedException {
        lock.lock();

        new Thread(() -> {
            try {
                lock.lock();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
            } finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(100000000);
        lock.unlock();
    }
}
