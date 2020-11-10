package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinDiffInBSTTest {

    @Test
    public void testMinDiffInBST() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(7),
                        new TreeNode(8)));
        int result = new MinDiffInBST().minDiffInBST(root);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void testMinDiffInBST2() {
        TreeNode root = new TreeNode(90,
                new TreeNode(69,
                        new TreeNode(49,
                                null,
                                new TreeNode(52)),
                        new TreeNode(89)),
                null);
        int result = new MinDiffInBST().minDiffInBST(root);
        Assert.assertEquals(result, 1);
    }
}