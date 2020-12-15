package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConvertBSTSum2Test {

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