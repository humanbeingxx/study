package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

public class AddOneRowToTreeTest {

    @Test
    public void testAddOneRow() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)),
                new TreeNode(6,
                        new TreeNode(5),
                        null));
        root = new AddOneRowToTree().addOneRow(root, 9, 4);
        System.out.println(root);
    }
}