package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SumOfLeftLeavesTest {

    @Test
    public void testSumOfLeftLeaves1() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        int result = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        Assert.assertEquals(result, 24);
    }

    @Test
    public void testSumOfLeftLeaves2() {
        TreeNode root = new TreeNode(3, null, null);
        int result = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testSumOfLeftLeaves3() {
        TreeNode root = null;
        int result = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        Assert.assertEquals(result, 0);
    }
}