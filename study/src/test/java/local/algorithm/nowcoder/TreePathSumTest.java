package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

public class TreePathSumTest {

    @Test
    public void testPathSum1() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(11,
                                new TreeNode(2),
                                new TreeNode(7))),
                new TreeNode(8,
                        null,
                        new TreeNode(9)));
        List<List<Integer>> result = new TreePathSum().pathSum(root, 22);
        System.out.println(result);
    }
}