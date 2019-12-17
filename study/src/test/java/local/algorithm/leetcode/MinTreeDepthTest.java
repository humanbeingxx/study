package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class MinTreeDepthTest {

    @Test
    public void testMinDepth1() {
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

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testMinDepth2() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5, null, null);

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testMinDepth3() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5,
                new BinaryTreeHasPathSum.TreeNode(9, null, null),
                new BinaryTreeHasPathSum.TreeNode(20,
                        new BinaryTreeHasPathSum.TreeNode(15, null, null),
                        new BinaryTreeHasPathSum.TreeNode(7, null, null)));

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 2);

        System.out.println(0b11111111111111111111111111111111);
        System.out.println(0b10000000000000000000000000000001);
        System.out.println(Integer.MIN_VALUE);
        //2147483645
        //2147483645
    }
}