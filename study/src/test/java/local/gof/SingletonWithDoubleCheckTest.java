package local.gof;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SingletonWithDoubleCheckTest {

    Object singleton = null;

    @Test
    public void testCheckPos() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    checkBefore();
                }
            }));
        }
        long startTime = System.currentTimeMillis();
        threads.forEach(Thread::start);
        System.out.println(System.currentTimeMillis() - startTime);

        threads.clear();
        for (int i = 0; i < 10000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    checkAfter();
                }
            }));
        }
        startTime = System.currentTimeMillis();
        threads.forEach(Thread::start);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private void checkBefore() {
        if (singleton != null) {
            return;
        }
        synchronized (SingletonWithDoubleCheck.class) {
            if (singleton == null) {
                singleton = new Object();
                singleton = null;
            }
        }
    }

    private void checkAfter() {
        if (singleton == null) {
            synchronized (SingletonWithDoubleCheck.class) {
                if (singleton == null) {
                    singleton = new Object();
                    singleton = null;
                }
            }
        }
    }
}