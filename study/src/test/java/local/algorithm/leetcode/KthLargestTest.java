package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;


/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class KthLargestTest {

    @Test
    public void testAdjust() {
        int[] nums = {7, 3, 8, 5, 1, 2};
        new KthLargest(3, nums).adjust(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testAdd() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        int result = 0;
        result = kthLargest.add(3);
        assertEquals(result, 4);

        result = kthLargest.add(5);
        assertEquals(result, 5);

        result = kthLargest.add(10);
        assertEquals(result, 5);

        result = kthLargest.add(9);
        assertEquals(result, 8);

        result = kthLargest.add(4);
        assertEquals(result, 8);
    }
}