package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:12
 */
public class FindTiltTest {

    @Test
    public void testFindTilt() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        int result = new FindTilt().findTilt(root);
        assertEquals(result, 1);
    }
}