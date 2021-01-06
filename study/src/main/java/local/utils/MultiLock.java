package local.utils;

import com.google.common.base.Preconditions;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class MultiLock {

    private static final int ARRAY_BASE_OFFSET;
    private static final int ARRAY_SHIFT;
    private static final sun.misc.Unsafe UNSAFE;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(ReentrantLock[].class);
            int scale = UNSAFE.arrayIndexScale(ReentrantLock[].class);
            if ((scale & (scale - 1)) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ARRAY_SHIFT = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private final ReentrantLock[] locks;

    public MultiLock() {
        this.locks = new ReentrantLock[2048];
    }

    public void lockAt(Object key) {
        int index = Math.abs(key.hashCode()) % locks.length;
        if (locks[index] == null) {
            tryInit(index);
        }
        locks[index].lock();
    }

    public void unlockAt(Object key) {
        int index = Math.abs(key.hashCode()) % locks.length;
        Preconditions.checkNotNull(locks[index]);
        locks[index].unlock();
    }

    private void tryInit(int index) {
        UNSAFE.compareAndSwapObject(locks,
                ((long) index << ARRAY_SHIFT) + ARRAY_BASE_OFFSET, null, new ReentrantLock());
    }
}
