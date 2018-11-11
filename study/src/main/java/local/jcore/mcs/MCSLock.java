package local.jcore.mcs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/28 下午4:40
 **/
public class MCSLock {

    private static class MCSNode {
        volatile boolean locked = true;
        volatile MCSNode next;
    }

    private AtomicReference<MCSNode> tail = new AtomicReference<>();

    private ThreadLocal<MCSNode> currentNode = ThreadLocal.withInitial(MCSNode::new);

    public void lock() {
        MCSNode current = currentNode.get();
        MCSNode preTail = tail.getAndSet(current);
        if (preTail != null) {
            preTail.next = current;
            while (current.locked) {

            }
        }
    }

    public void unlock() {
        MCSNode current = currentNode.get();
        if (current.next == null) {
            if (tail.compareAndSet(current, null)) {
                return;
            }
            // 这里等待新设置的tail节点将next设置为本节点（preTail.next = current）
            while (current.next == null) {

            }
        }
        current.next.locked = false;
    }
}
