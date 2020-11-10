package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-18
 **/
public class BstToGstTest {

    @Test
    public void testBstToGst() {
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                null,
                                new TreeNode(3))),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8))));
        root = new BstToGst().bstToGst(root);
        System.out.println(root.val);
    }
}