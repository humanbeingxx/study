package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-28
 **/
public class CoinChangeTest {

    @Test
    public void testCoinChange1() {
        int result = new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
        assertEquals(result, 3);
    }

    @Test
    public void testCoinChange2() {
        int result = new CoinChange().coinChange(new int[]{2}, 3);
        assertEquals(result, -1);
    }

    @Test
    public void testCoinChange3() {
        int result = new CoinChange().coinChange(new int[]{1, 2}, 3);
        assertEquals(result, 2);
    }

    @Test
    public void testCoinChange4() {
        int result = new CoinChange().coinChange(new int[]{1, Integer.MAX_VALUE}, 2);
        assertEquals(result, 2);
    }

    @Test
    public void testCoinChange5() {
        int result = new CoinChange().coinChange(new int[]{1}, 1);
        assertEquals(result, 1);
    }
}