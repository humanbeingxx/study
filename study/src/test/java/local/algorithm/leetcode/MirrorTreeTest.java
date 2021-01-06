package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/5/28 14:40
 */
public class MirrorTreeTest {

    @Test
    public void testMirrorTree() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        new MirrorTree().mirrorTree(root);
        System.out.println(root);
    }
}