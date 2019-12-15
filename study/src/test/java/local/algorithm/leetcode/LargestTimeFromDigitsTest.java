package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:59
 */
public class LargestTimeFromDigitsTest {

    @Test
    public void testLargestTimeFromDigits() {
        String result = new LargestTimeFromDigits().largestTimeFromDigits(new int[]{1, 2, 3, 4});
        System.out.println(result);

        result = new LargestTimeFromDigits().largestTimeFromDigits(new int[]{5,5,5,5});
        System.out.println(result);

        result = new LargestTimeFromDigits().largestTimeFromDigits(new int[]{2,3,5,9});
        System.out.println(result);

        result = new LargestTimeFromDigits().largestTimeFromDigits(new int[]{2,0,6,6});
        System.out.println(result);
    }
}