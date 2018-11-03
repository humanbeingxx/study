package local.before.d1101;

import org.testng.Assert;
import org.testng.annotations.Test;

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
            return obj != null && obj.getClass() == MyTest.class && this.num == ((MyTest)obj).num;
        }
    }

    @Test
    public void test() {
        MyTest myTest1 = new MyTest(1);
        MyTest myTest2 = new MyTest(1);

        Assert.assertNotEquals(myTest1.hashCode(), myTest2.hashCode());
        Assert.assertEquals(myTest1, myTest2);
    }


}
