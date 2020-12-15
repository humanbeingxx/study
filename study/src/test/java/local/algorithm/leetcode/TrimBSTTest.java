package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 21:14
 */
public class TrimBSTTest {

    @Test
    public void testTrimBST() {
        TreeNode root = new TreeNode(3,
                new TreeNode(0,
                        null,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null)),
                new TreeNode(4, null, null));
        TreeNode result = new TrimBST().trimBST(root, 1, 3);
        show(result);
    }

    private void show(TreeNode node) {
        if (node == null) {
            return;
        }
        show(node.left);
        System.out.println(node.val);
        show(node.right);
    }
}