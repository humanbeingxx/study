package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 21:33
 */
public class MergeTreesTest {

    @Test
    public void testMergeTrees() {
        TreeNode t1 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5, null, null),
                        null),
                new TreeNode(2, null, null));

        TreeNode t2 = new TreeNode(2,
                new TreeNode(1,
                        null,
                        new TreeNode(4, null, null)),
                new TreeNode(3,
                        null,
                        new TreeNode(7, null, null)));

        TreeNode result = new MergeTrees().mergeTrees(t1, t2);
        show(result);
    }

    private void show(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.println(t.val);
        show(t.left);
        show(t.right);
    }
}