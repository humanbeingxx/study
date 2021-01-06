package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MostFrequentSubtreeSumTest {

    @Test
    public void testFindFrequentTreeSum0() {
        int[] result = new MostFrequentSubtreeSum().findFrequentTreeSum(null);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFindFrequentTreeSum1() {
        TreeNode root = new TreeNode(5,
                new TreeNode(2),
                new TreeNode(-3));
        int[] result = new MostFrequentSubtreeSum().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFindFrequentTreeSum2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(2),
                new TreeNode(-5));
        int[] result = new MostFrequentSubtreeSum().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(result));
    }
}