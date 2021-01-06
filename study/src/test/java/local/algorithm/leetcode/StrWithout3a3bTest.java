package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class StrWithout3a3bTest {

    @Test
    public void testStrWithout3a3b1() {
        String result = new StrWithout3a3b().strWithout3a3b(1, 2);
        System.out.println(result);
    }

    @Test
    public void testStrWithout3a3b2() {
        String result = new StrWithout3a3b().strWithout3a3b(4, 1);
        System.out.println(result);
    }
}