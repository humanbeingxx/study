package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class ConvertBSTSumTest {

    @Test
    public void testConvertBST() {
        TreeNode root = new TreeNode(5,
                new TreeNode(2),
                new TreeNode(13));
        TreeNode result = new ConvertBSTSum().convertBST(root);
        assertEquals(result.val, 18);
        assertEquals(result.left.val, 20);
        assertEquals(result.right.val, 13);
    }
}