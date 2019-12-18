package local.algorithm.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 21:16
 */
public class LongestUnivaluePathTest {

    @Test
    public void testLongestUnivaluePath1() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5,
                new BinaryTreeHasPathSum.TreeNode(4,
                        new BinaryTreeHasPathSum.TreeNode(11,
                                new BinaryTreeHasPathSum.TreeNode(7, null, null),
                                new BinaryTreeHasPathSum.TreeNode(2, null, null))
                        , null),
                new BinaryTreeHasPathSum.TreeNode(5,
                        new BinaryTreeHasPathSum.TreeNode(13, null, null),
                        new BinaryTreeHasPathSum.TreeNode(5,
                                null,
                                new BinaryTreeHasPathSum.TreeNode(1, null, null))));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testLongestUnivaluePath2() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5,
                new BinaryTreeHasPathSum.TreeNode(5,
                        new BinaryTreeHasPathSum.TreeNode(5,
                                new BinaryTreeHasPathSum.TreeNode(7, null, null),
                                new BinaryTreeHasPathSum.TreeNode(5, null, null))
                        , null),
                new BinaryTreeHasPathSum.TreeNode(5,
                        new BinaryTreeHasPathSum.TreeNode(13, null, null),
                        new BinaryTreeHasPathSum.TreeNode(5,
                                null,
                                new BinaryTreeHasPathSum.TreeNode(1, null, null))));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testLongestUnivaluePath3() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5, null, null);
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testLongestUnivaluePath4() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(1,
                new BinaryTreeHasPathSum.TreeNode(4,
                        new BinaryTreeHasPathSum.TreeNode(4, null, null),
                        new BinaryTreeHasPathSum.TreeNode(4, null, null)),
                new BinaryTreeHasPathSum.TreeNode(5,
                        null,
                        new BinaryTreeHasPathSum.TreeNode(5, null,
                                null)));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testLongestUnivaluePath5() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(5,
                new BinaryTreeHasPathSum.TreeNode(4,
                        new BinaryTreeHasPathSum.TreeNode(1, null, null),
                        new BinaryTreeHasPathSum.TreeNode(1, null, null)),
                new BinaryTreeHasPathSum.TreeNode(5,
                        null,
                        new BinaryTreeHasPathSum.TreeNode(5, null,
                                null)));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

}