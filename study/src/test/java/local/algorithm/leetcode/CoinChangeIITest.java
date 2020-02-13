package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-13
 **/
public class CoinChangeIITest {

    @Test
    public void testChange1() {
        int result = new CoinChangeII().change(5, new int[]{1, 2, 5});
        assertEquals(result, 4);
    }

    @Test
    public void testChange2() {
        int result = new CoinChangeII().change(10, new int[]{10});
        assertEquals(result, 1);
    }

    @Test
    public void testChange3() {
        int result = new CoinChangeII().change(3, new int[]{2});
        assertEquals(result, 0);
    }
}