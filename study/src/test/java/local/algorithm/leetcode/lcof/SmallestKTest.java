package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 15:27
 */
public class SmallestKTest {

    @Test
    public void testSmallestK1() {
        int[] result = new SmallestK().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSmallestK2() {
        int[] result = new SmallestK().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 40);
        System.out.println(Arrays.toString(result));
    }
}