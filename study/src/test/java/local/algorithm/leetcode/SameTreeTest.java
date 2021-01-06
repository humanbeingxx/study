package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class SameTreeTest {

    @Test
    public void testIsSameTree1() {
        TreeNode p = new TreeNode(5, null, null);
        TreeNode q = new TreeNode(5, null, null);

        boolean sameTree = new SameTree().isSameTree(p, q);
        Assert.assertTrue(sameTree);
    }

    @Test
    public void testIsSameTree2() {
        TreeNode p = new TreeNode(5, null, null);
        TreeNode q = new TreeNode(3, null, null);

        boolean sameTree = new SameTree().isSameTree(p, q);
        Assert.assertFalse(sameTree);
    }

    @Test
    public void testIsSameTree3() {
        TreeNode p = new TreeNode(1,
                new TreeNode(2, null, null),
                null);
        TreeNode q = new TreeNode(1, null,
                new TreeNode(2, null, null));

        boolean sameTree = new SameTree().isSameTree(p, q);
        Assert.assertFalse(sameTree);
    }

    @Test
    public void testIsSameTree4() {
        TreeNode p = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(1, null, null));
        TreeNode q = new TreeNode(1,
                new TreeNode(1, null, null),
                new TreeNode(2, null, null));

        boolean sameTree = new SameTree().isSameTree(p, q);
        Assert.assertFalse(sameTree);
    }

    @Test
    public void testIsSameTree5() {
        TreeNode p = new TreeNode(1,
                null,
                new TreeNode(1, null, null));
        TreeNode q = new TreeNode(1,
                null,
                new TreeNode(1, null, null));

        boolean sameTree = new SameTree().isSameTree(p, q);
        Assert.assertTrue(sameTree);
    }
}