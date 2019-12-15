package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 14:42
 */
public class CalculateFractionTest {

    @Test
    public void testFraction() {
        int[] fraction = CalculateFraction.fraction(new int[]{0, 2, 0, 2});
        System.out.println(Arrays.toString(fraction));
    }

    @Test
    public void testFraction2() {
        int[] fraction = CalculateFraction.fraction(new int[]{0, 0, 3});
        System.out.println(Arrays.toString(fraction));
    }
}