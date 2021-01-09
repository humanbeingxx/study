package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

public class MaxProfitIIITest {

    @Test
    public void testMaxProfit1() {
        int result = new MaxProfitIII().maxProfit(new int[]{3,3,5,0,0,3,1,4});
        assertEquals(result, 6);
    }

    @Test
    public void testMaxProfit2() {
        int result = new MaxProfitIII().maxProfit(new int[]{1,2,3,4,5});
        assertEquals(result, 4);
    }

    @Test
    public void testMaxProfit3() {
        int result = new MaxProfitIII().maxProfit(new int[]{5,4,3,2,1});
        assertEquals(result, 0);
    }

    @Test
    public void testMaxProfit4() {
        int result = new MaxProfitIII().maxProfit(new int[]{1});
        assertEquals(result, 0);
    }

    @Test
    public void random() {
        int[] data = new int[20];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(data));
    }
}