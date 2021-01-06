package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PrintTreeTest {

    @Test
    public void testHeight() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3));
        int result = new PrintTree().height(root);
        assertEquals(result, 3);
    }

    @Test
    public void testPrintTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3));
        List<List<String>> result = new PrintTree().printTree(root);
        result.forEach(System.out::println);
    }
}