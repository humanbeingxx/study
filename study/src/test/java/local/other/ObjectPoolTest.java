package local.other;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.PooledSoftReference;
import org.apache.commons.pool2.impl.SoftReferenceObjectPool;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectPoolTest {

    public static class MyObject {
        static AtomicInteger GLOBAL_ID = new AtomicInteger(0);
        int id;
        long value;

        public MyObject() {
            id = GLOBAL_ID.incrementAndGet();
        }
    }

    @Test
    public void testPool() throws Exception {
        ObjectPool<MyObject> pool = new SoftReferenceObjectPool<>(new BasePooledObjectFactory<MyObject>() {
            @Override
            public MyObject create() {
                MyObject myObject = new MyObject();
                myObject.value = System.currentTimeMillis();
                return myObject;
            }

            @Override
            public PooledObject<MyObject> wrap(MyObject obj) {
                return new PooledSoftReference<>(new SoftReference<>(obj));
            }

            @Override
            public void passivateObject(PooledObject<MyObject> p) throws Exception {
                p.getObject().value = 0;
            }
        });

        MyObject borrowObject = pool.borrowObject();
        System.out.println(borrowObject.id);
        System.out.println(borrowObject.value);
        pool.returnObject(borrowObject);
        borrowObject = pool.borrowObject();
        System.out.println(borrowObject.id);
        System.out.println(borrowObject.value);
    }
}
