package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 21:00
 */
public class BinaryTreeHasPathSumTest {

    @Test
    public void testHasPathSum() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(2, null, null))
                        , null),
                new TreeNode(8,
                        new TreeNode(13, null, null),
                        new TreeNode(4,
                                null,
                                new TreeNode(1, null, null))));

        boolean have = new BinaryTreeHasPathSum().hasPathSum(root, 22);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 18);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 1);
        Assert.assertFalse(have);
    }

    @Test
    public void testHasPathSum2() {
        TreeNode root = new TreeNode(5, null, null);

        boolean have = new BinaryTreeHasPathSum().hasPathSum(root, 22);
        Assert.assertFalse(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 18);
        Assert.assertFalse(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 1);
        Assert.assertFalse(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 5);
        Assert.assertTrue(have);
    }

    @Test
    public void testHasPathSum3() {
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3, null, null));

        boolean have = new BinaryTreeHasPathSum().hasPathSum(root, -5);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 18);
        Assert.assertFalse(have);
    }
}