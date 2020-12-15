package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.common.TreeNode;
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
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        null));
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(3, 2, 1));
    }

    @Test
    public void testPostorderTraversal2() {
        TreeNode root = new TreeNode(1, null, null);
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(1));
    }

    @Test
    public void testPostorderTraversal3() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        List<Integer> result = new PostTraversalByIter().postorderTraversal(root);
        Assert.assertEquals(result, Lists.newArrayList(4, 5, 2, 6, 7, 3, 1));
    }

}