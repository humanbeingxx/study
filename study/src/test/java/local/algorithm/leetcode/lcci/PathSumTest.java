package local.algorithm.leetcode.lcci;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 22:05
 */
public class PathSumTest {

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        int result = new PathSum().pathSum(root, 22);
        assertEquals(result, 3);
    }
}