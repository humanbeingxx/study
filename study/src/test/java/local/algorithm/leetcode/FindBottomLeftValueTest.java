package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindBottomLeftValueTest {

    @Test
    public void testFindBottomLeftValue() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(7),
                                null),
                        new TreeNode(6)));
        int result = new FindBottomLeftValue().findBottomLeftValue(root);
        assertEquals(result, 7);
    }
}