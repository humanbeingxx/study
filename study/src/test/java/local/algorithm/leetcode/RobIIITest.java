package local.algorithm.leetcode;

import org.testng.annotations.Test;

import local.algorithm.leetcode.common.TreeNode;
import static org.testng.Assert.*;

public class RobIIITest {

    @Test
    public void testRob1() {
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5,
                        null,
                        new TreeNode(1)));
        int result = new RobIII().rob(root);
        assertEquals(result, 9);
    }

    @Test
    public void testRob2() {
        TreeNode root = new TreeNode(3,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(3,
                        null,
                        new TreeNode(1)));
        int result = new RobIII().rob(root);
        assertEquals(result, 7);
    }
}