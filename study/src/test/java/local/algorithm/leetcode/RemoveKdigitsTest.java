package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class RemoveKdigitsTest {

    @Test
    public void testRemoveKdigits1() {
        String result = new RemoveKdigits().removeKdigits("1432219", 3);
        assertEquals(result, "1219");
    }

    @Test
    public void testRemoveKdigits2() {
        String result = new RemoveKdigits().removeKdigits("10200", 1);
        assertEquals(result, "200");
    }

    @Test
    public void testRemoveKdigits3() {
        String result = new RemoveKdigits().removeKdigits("10", 2);
        assertEquals(result, "0");
    }

    @Test
    public void testRemoveKdigits4() {
        String result = new RemoveKdigits().removeKdigits("10000", 1);
        assertEquals(result, "0");
    }

    @Test
    public void testRemoveKdigits5() {
        String result = new RemoveKdigits().removeKdigits("1234567890", 9);
        assertEquals(result, "0");
    }

    @Test
    public void testRemoveKdigits6() {
        String result = new RemoveKdigits().removeKdigits("111119", 3);
        assertEquals(result, "111");
    }
}