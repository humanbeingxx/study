package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/4 22:06
 */
public class MyMatchTest {

    @Test
    public void testIsMatch1() {
        boolean match = new MyMatch().isMatch("aa", "a");
        assertFalse(match);
    }

    @Test
    public void testIsMatch2() {
        boolean match = new MyMatch().isMatch("aa", "*");
        assertTrue(match);
    }

    @Test
    public void testIsMatch3() {
        boolean match = new MyMatch().isMatch("adceb", "*a*b");
        assertTrue(match);
    }

    @Test
    public void testIsMatch4() {
        boolean match = new MyMatch().isMatch("acdcb", "a*c?b");
        assertFalse(match);
    }

    @Test
    public void testIsMatch5() {
        boolean match = new MyMatch().isMatch("", "*");
        assertTrue(match);
    }

    @Test
    public void testIsMatch6() {
        boolean match = new MyMatch().isMatch("", "");
        assertTrue(match);
    }
}