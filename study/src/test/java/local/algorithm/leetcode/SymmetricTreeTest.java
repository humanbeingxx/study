package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class SymmetricTreeTest {

    @Test
    public void testIsSymmetric1() {
        //1,2,2,3,4,4,3
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        null),
                new TreeNode(2,
                        null,
                        new TreeNode(3, null, null)));
        boolean result = new SymmetricTree().isSymmetric(root);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSymmetric2() {
        //1,2,2,null,3,null,3
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3, null, null)),
                new TreeNode(2,
                        null,
                        new TreeNode(3, null, null)));
        boolean result = new SymmetricTree().isSymmetric(root);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsSymmetric3() {
        boolean result = new SymmetricTree().isSymmetric(null);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSymmetric4() {
        //1,2,2,null,3,null,3
        TreeNode root = new TreeNode(1, null, new TreeNode(1, null, null));
        boolean result = new SymmetricTree().isSymmetric(root);
        Assert.assertFalse(result);
    }
}