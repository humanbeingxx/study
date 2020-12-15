package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 21:11
 */
public class FindUnsortedSubarrayTest {

    @Test
    public void testFindUnsortedSubarray() {
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{3, 2, 1}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{1, 2}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{1}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{}));
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2, 2}));
    }
}