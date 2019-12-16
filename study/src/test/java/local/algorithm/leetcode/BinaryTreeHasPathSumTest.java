package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 21:00
 */
public class BinaryTreeHasPathSumTest {

    @Test
    public void testHasPathSum() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5,
                new BinaryTreeHasPathSum.TreeNode(4,
                        new BinaryTreeHasPathSum.TreeNode(11,
                                new BinaryTreeHasPathSum.TreeNode(7, null, null),
                                new BinaryTreeHasPathSum.TreeNode(2, null, null))
                        , null),
                new BinaryTreeHasPathSum.TreeNode(8,
                        new BinaryTreeHasPathSum.TreeNode(13, null, null),
                        new BinaryTreeHasPathSum.TreeNode(4,
                                null,
                                new BinaryTreeHasPathSum.TreeNode(1, null, null))));

        boolean have = new BinaryTreeHasPathSum().hasPathSum(root, 22);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 18);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 1);
        Assert.assertFalse(have);
    }

    @Test
    public void testHasPathSum2() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5, null, null);

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
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(-2, null, new BinaryTreeHasPathSum.TreeNode(-3, null, null));

        boolean have = new BinaryTreeHasPathSum().hasPathSum(root, -5);
        Assert.assertTrue(have);

        have = new BinaryTreeHasPathSum().hasPathSum(root, 18);
        Assert.assertFalse(have);
    }
}