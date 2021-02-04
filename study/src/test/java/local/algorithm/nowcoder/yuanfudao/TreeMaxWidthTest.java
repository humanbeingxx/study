package local.algorithm.nowcoder.yuanfudao;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TreeMaxWidthTest {

    @Test
    public void testMaxWidth1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8)),
                        new TreeNode(5,
                                new TreeNode(9))),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7,
                                new TreeNode(10))));
        int result = new TreeMaxWidth().maxWidth(root);
        assertEquals(result, 4);
    }

    @Test
    public void testMaxWidth2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(8)),
                        new TreeNode(5,
                                new TreeNode(9),
                                new TreeNode(9))),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7,
                                new TreeNode(10))));
        int result = new TreeMaxWidth().maxWidth(root);
        assertEquals(result, 5);
    }
}