package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class PostTraversalByIterTest {

    @Test
    public void testPostorderTraversal1() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(1,
                null,
                new BinaryTreeHasPathSum.TreeNode(2,
                        new BinaryTreeHasPathSum.TreeNode(3, null, null),
                        null));
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(3, 2, 1));
    }

    @Test
    public void testPostorderTraversal2() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(1, null, null);
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(1));
    }

    @Test
    public void testPostorderTraversal3() {
        BinaryTreeHasPathSum.TreeNode root = new BinaryTreeHasPathSum.TreeNode(1,
                new BinaryTreeHasPathSum.TreeNode(2,
                        new BinaryTreeHasPathSum.TreeNode(4, null, null),
                        new BinaryTreeHasPathSum.TreeNode(5, null, null)),
                new BinaryTreeHasPathSum.TreeNode(3,
                        new BinaryTreeHasPathSum.TreeNode(6, null, null),
                        new BinaryTreeHasPathSum.TreeNode(7, null, null)));
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(4, 5, 2, 6, 7, 3, 1));
    }

}