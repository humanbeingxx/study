package local.jcore;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/4 下午1:15
 **/
public class AutoBoxTest {

    @Test
    public void test() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        Integer c = Integer.valueOf(1);
        Integer d = 1;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
    }

    @Test
    public void testBig() {
        Integer a = new Integer(12345678);
        Integer b = new Integer(12345678);
        Integer c = Integer.valueOf(12345678);
        Integer d = 12345678;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
    }

    @Test
    public void testWithCalculation() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
    }

    @Test
    public void testLong() {
        Integer a = 1;
        Integer b = 2;
        Long c = 3L;

        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
    }
}
