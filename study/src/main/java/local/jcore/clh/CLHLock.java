package local.jcore.clh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/27 下午2:49
 **/
public class CLHLock implements Lock {

    private AtomicReference<CLHNode> tail;

    private ThreadLocal<CLHNode> myNode = ThreadLocal.withInitial(CLHNode::new);

    public CLHLock() {
        // 根据dog李的jdk源码，CLH需要一个伪头结点。但是实际上这段代码，头为空也能工作，因为没有preNode
        CLHNode dummy = new CLHNode();
        dummy.unlock();
        tail = new AtomicReference<>(dummy);
    }

    public void lockWithSleep() {
        CLHNode currentMyNode = myNode.get();
        CLHNode preTail = tail.getAndSet(currentMyNode);
        if (preTail == null) {
            return;
        }
        int tryCount = 0;
        while (preTail.isLocked()) {
            tryCount++;
            if (tryCount % 100000 == 0) {
                System.out.println("have to stop " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void lock() {
        CLHNode currentMyNode = myNode.get();
        CLHNode preTail = tail.getAndSet(currentMyNode);
        if (preTail != null) {
            while (preTail.isLocked()) {
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unlock() {
        CLHNode clhNode = myNode.get();

        if (clhNode == null || !clhNode.isLocked()) {
            return;
        }

        myNode.remove();
        clhNode.unlock();
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }

}
