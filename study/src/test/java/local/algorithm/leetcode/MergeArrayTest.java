package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 22:03
 */
public class MergeArrayTest {

    @Test
    public void testMerge1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new MergeArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void testMerge2() {
        int[] nums1 = {1, 2, 0, 0, 0, 0};
        int[] nums2 = {2, 5, 6, 6};

        new MergeArray().merge(nums1, 2, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void testMerge3() {
        int[] nums1 = {1, 0};
        int[] nums2 = {2};

        new MergeArray().merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}