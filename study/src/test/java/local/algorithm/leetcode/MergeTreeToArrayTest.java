package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 20:27
 */
public class MergeTreeToArrayTest {

    @Test
    public void testGetAllElements1() {
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(4));
        TreeNode root2 = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(3));
        List<Integer> result = new MergeTreeToArray().getAllElements(root1, root2);
        assertEquals(result, Lists.newArrayList(0, 1, 1, 2, 3, 4));
    }

    @Test
    public void testGetAllElements2() {
        TreeNode root1 = new TreeNode(0,
                new TreeNode(-10),
                new TreeNode(10));
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2)),
                new TreeNode(7));
        List<Integer> result = new MergeTreeToArray().getAllElements(root1, root2);
        assertEquals(result, Lists.newArrayList(-10,0,0,1,2,5,7,10));
    }

    @Test
    public void testGetAllElements3() {
        TreeNode root1 = new TreeNode(0,
                new TreeNode(-10),
                new TreeNode(10));
        TreeNode root2 = null;
        List<Integer> result = new MergeTreeToArray().getAllElements(root1, root2);
        assertEquals(result, Lists.newArrayList(-10,0,10));
    }
}