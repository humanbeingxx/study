package local.other;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/6/21 下午5:12
 **/
public class JavaStringTest {

    @Test
    public void test() {
        String a = "this is a";
        String A = "this is a";

        Assert.assertTrue(a == A);

        String aa = new String("this is a");
        String AA = new String("this is a");

        Assert.assertFalse(aa == AA);
        System.out.println(System.identityHashCode(aa));
        System.out.println(System.identityHashCode(AA));

        String aaa = new String("this is a").intern();
        Assert.assertTrue(a == aaa);
    }

    @Test
    public void test2() {
        String aaa = new String(new StringBuilder().append("this").append(" is ").append("a")).intern();
        String a = "this is a";

        Assert.assertTrue(aaa == a);
    }

    @Test
    public void test3() {
        int[][][] aaa = new int[][][]{{{1}}};
        int[][] aa = new int[][]{{1}};

        Class aaaClass = aaa.getClass();
        Class aaClass = aa.getClass();

        Assert.assertFalse(aaClass.isAssignableFrom(aaaClass));
        Assert.assertTrue(aaClass.equals(aaa[0].getClass()));

    }
}
