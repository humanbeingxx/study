package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 20:15
 */
public class SumRootToLeafTest {

    @Test
    public void testSumRootToLeaf() {
        TreeNode root = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0, null, null),
                        new TreeNode(1, null, null)),
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(1, null, null)));
        int result = new SumRootToLeaf().sumRootToLeaf(root);
        assertEquals(result, 22);
    }
}