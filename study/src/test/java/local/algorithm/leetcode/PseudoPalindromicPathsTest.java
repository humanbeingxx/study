package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PseudoPalindromicPathsTest {

    @Test
    public void testPseudoPalindromicPaths1() {
        TreeNode root = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(1)),
                new TreeNode(1,
                        null,
                        new TreeNode(1)));
        int result = new PseudoPalindromicPaths().pseudoPalindromicPaths(root);
        assertEquals(result, 2);
    }
}