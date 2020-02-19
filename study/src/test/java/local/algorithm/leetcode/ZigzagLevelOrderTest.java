package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class ZigzagLevelOrderTest {

    @Test
    public void testZigzagLevelOrder1() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        List<List<Integer>> result = new ZigzagLevelOrder().zigzagLevelOrder(root);
        result.forEach(System.out::println);
    }

    @Test
    public void testZigzagLevelOrder2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        null,
                        new TreeNode(5)));
        List<List<Integer>> result = new ZigzagLevelOrder().zigzagLevelOrder(root);
        result.forEach(System.out::println);
    }
}