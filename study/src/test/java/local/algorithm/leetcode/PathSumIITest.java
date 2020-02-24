package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class PathSumIITest {

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(11),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        List<List<Integer>> result = new PathSumII().pathSum(root, 22);
        result.forEach(System.out::println);
    }
}