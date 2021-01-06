package local.algorithm.leetcode.lcof;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/13 16:49
 */
public class SubStructureTest {

    @Test
    public void testIsSubStructure1() {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        boolean result = new SubStructure().isSubStructure(A, B);
        assertTrue(result);
    }
}