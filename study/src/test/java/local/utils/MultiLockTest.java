package local.utils;

import org.testng.annotations.Test;

public class MultiLockTest {

    static class MyUser {
        int id;

        public MyUser(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            return o != null &&
                    o.getClass() == MyUser.class &&
                    ((MyUser) o).id == id;
        }

        @Override
        public int hashCode() {
            return id % 10;
        }
    }

    @Test
    public void test() throws Exception {
        MultiLock lock = new MultiLock();
        for (int i = 0; i < 200; i++) {
            int id = i;
            new Thread(() -> {
                MyUser key = new MyUser(id);
                try {
                    lock.lockAt(key);
                    System.out.println(Thread.currentThread().getName() + " get lock with id " + id);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlockAt(key);
                }
            }).start();
        }
        Thread.sleep(100000);
    }
}