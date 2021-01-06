package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 21:56
 */
public class IncreasingBSTTest {

    @Test
    public void testIncreasingBST() {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        new TreeNode(4, null, null)),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(9, null, null))));
        TreeNode result = new IncreasingBST().increasingBST(root);
        int val = 1;
        while (result != null) {
            Assert.assertEquals(result.val, val++);
            result = result.right;
        }
    }

    @Test
    public void testIncreasingBST2() {
        TreeNode root = null;
        TreeNode result = new IncreasingBST().increasingBST(root);
        Assert.assertNull(result);
    }

    @Test
    public void testIncreasingBST3() {
        TreeNode root = new TreeNode(5,
                new TreeNode(3, null, null),
                null);
        TreeNode result = new IncreasingBST().increasingBST(root);
        Assert.assertEquals(result.val, 3);
        Assert.assertEquals(result.right.val, 5);
    }

    @Test
    public void testIncreasingBST4() {
        //[265,null,519,605]
        TreeNode root = new TreeNode(265,
                null,
                new TreeNode(519,
                        new TreeNode(605, null, null),
                        null)
        );
        TreeNode result = new IncreasingBST().increasingBST(root);
        Assert.assertEquals(result.val, 265);
        Assert.assertNull(result.left);
        Assert.assertEquals(result.right.val, 605);
        Assert.assertNull(result.right.left);
        Assert.assertEquals(result.right.right.val, 519);
        Assert.assertNull(result.right.right.left);
    }

    @Test
    public void testIncreasingBST5() {
        //[54,null,57,788,null,null,876]
        TreeNode root = new TreeNode(54,
                null,
                new TreeNode(57,
                        new TreeNode(788,
                                null,
                                new TreeNode(876, null, null)),
                        null)
        );
        TreeNode result = new IncreasingBST().increasingBST(root);
        Assert.assertEquals(result.val, 54);
        Assert.assertNull(result.left);
        Assert.assertEquals(result.right.val, 788);
        Assert.assertNull(result.right.left);
        Assert.assertEquals(result.right.right.val, 876);
        Assert.assertNull(result.right.right.left);
        Assert.assertEquals(result.right.right.right.val, 57);
        Assert.assertNull(result.right.right.right.left);
    }


}