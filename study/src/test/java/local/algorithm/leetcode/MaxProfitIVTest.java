package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class MaxProfitIVTest {

    @Test
    public void testMaxProfit1() {
        int result = new MaxProfitIV().maxProfit(2, new int[]{1, 3, 1, 4, 1, 2, 1, 5});
        assertEquals(result, 7);
    }

    @Test
    public void testMaxProfit2() {
        int result = new MaxProfitIV().maxProfit(1, new int[]{3, 7, 5, 6, 6, 10});
        assertEquals(result, 7);
    }

    @Test
    public void testMaxProfit3() {
        int result = new MaxProfitIV().maxProfit(2, new int[]{4, 2, 1, 7});
        assertEquals(result, 6);
    }

    @Test
    public void testMaxProfit4() {
        int result = new MaxProfitIV().maxProfit(2, new int[]{1,2,3,4,5});
        assertEquals(result, 4);
    }

    @Test
    public void testRandom() {
        for (int t = 0; t < 10; t++) {
            int[] data = new int[1000];
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                data[i] = random.nextInt(15);
            }
            System.out.println(Arrays.toString(data));
            int result = new MaxProfitIV().maxProfit(10, data);
            System.out.println(result);
        }
    }
}