package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-02-20
 **/
public class CountCompleteTreeNodesTest {

    @Test
    public void testCountNodes1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));
        int result = new CountCompleteTreeNodes().countNodes(root);
        assertEquals(result, 6);
    }

    @Test
    public void testCountNodes2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        int result = new CountCompleteTreeNodes().countNodes(root);
        assertEquals(result, 7);
    }

    @Test
    public void testCountNodes3() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        int result = new CountCompleteTreeNodes().countNodes(root);
        assertEquals(result, 5);
    }

    @Test
    public void testCountNodes4() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3));
        int result = new CountCompleteTreeNodes().countNodes(root);
        assertEquals(result, 4);
    }

    @Test
    public void testCountNodes5() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        int result = new CountCompleteTreeNodes().countNodes(root);
        assertEquals(result, 3);
    }
}