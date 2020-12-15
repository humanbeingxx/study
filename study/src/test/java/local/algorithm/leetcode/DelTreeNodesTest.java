package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-04
 **/
public class DelTreeNodesTest {

    @Test
    public void testDelNodes() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        List<TreeNode> result = new DelTreeNodes().delNodes(root, new int[]{3, 5});
        System.out.println(result.size());
    }
}