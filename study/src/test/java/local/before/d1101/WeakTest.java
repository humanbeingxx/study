package local.before.d1101;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.WeakReference;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午5:45
 **/
public class WeakTest {

    class MyWeakReference<T> extends WeakReference<T> {

        String value;

        public MyWeakReference(T referent, String value) {
            super(referent);
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Test
    public void test() throws InterruptedException {
        String value = new String("123");
        WeakReference<String> reference = new WeakReference<String>(value) {

        };
        value = null;
        System.gc();
        Thread.sleep(10);
        Assert.assertNull(reference.get());
    }

    @Test
    public void test2() throws InterruptedException {
        String ref = new String("123");
        String value = new String("456");
        MyWeakReference<String> reference = new MyWeakReference<String>(ref, value);
        ref = null;
        value = null;
        System.gc();
        Thread.sleep(10);
        Assert.assertNull(reference.get());
        Assert.assertNotNull(reference.getValue());
    }
}
