package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class RangeBitwiseAndTest {

    @Test
    public void testRangeBitwiseAnd() {
        int result = new RangeBitwiseAnd().rangeBitwiseAnd(Integer.MAX_VALUE - 10, Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(result) + ":" + result);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        int m = random.nextInt(1000000);
        int n = m + random.nextInt(10000000);
        int result = new RangeBitwiseAnd().rangeBitwiseAnd(m, n);
        System.out.println(m + ":" + n + ":" + result);
        result = new RangeBitwiseAnd().rangeBitwiseAnd(m, m + 1111);
        System.out.println(m + ":" + (m + 1111) + ":" + result);

    }
}