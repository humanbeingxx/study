package local.algorithm.leetcode.lcci;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 19:50
 */
public class InorderSuccessorTest {

    @Test
    public void testInorderSuccessor1() {
        TreeNode p = new TreeNode(1);
        TreeNode root = new TreeNode(2,
                p,
                new TreeNode(3));
        TreeNode result = new InorderSuccessor().inorderSuccessor(root, p);
        assertSame(result, root);
    }

    @Test
    public void testInorderSuccessor2() {
        TreeNode p = new TreeNode(6);
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                p);
        TreeNode result = new InorderSuccessor().inorderSuccessor(root, p);
        assertSame(result, null);
    }

    @Test
    public void testInorderSuccessor3() {
        TreeNode p = new TreeNode(2,
                new TreeNode(1),
                null);
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        p,
                        new TreeNode(4)),
                new TreeNode(6));
        TreeNode result = new InorderSuccessor().inorderSuccessor(root, p);
        assertSame(result.val, 3);
    }
}