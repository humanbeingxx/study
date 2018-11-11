package local.before.d1101;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午5:11
 **/
public class HashEqualTest {

    static class MyTest {

        public int num;

        public MyTest(int num) {
            this.num = num;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj != null && obj.getClass() == MyTest.class && this.num == ((MyTest) obj).num;
        }
    }

    @Test
    public void test() {
        MyTest myTest1 = new MyTest(1);
        MyTest myTest2 = new MyTest(1);

        Assert.assertNotEquals(myTest1.hashCode(), myTest2.hashCode());
        Assert.assertEquals(myTest1, myTest2);
    }

    @Test
    public void testSort() {
        Collections.sort(Lists.newArrayList(new MyTest(1), new MyTest(2)), new Comparator<MyTest>() {
            @Override
            public int compare(MyTest o1, MyTest o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                return o1.num - o2.num;
            }
        });
    }
}
