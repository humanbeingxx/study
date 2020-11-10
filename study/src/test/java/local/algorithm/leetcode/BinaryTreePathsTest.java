package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class BinaryTreePathsTest {

    @Test
    public void testBinaryTreePaths() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5, null, null)),
                new TreeNode(3, null, null));
        List<String> result = new BinaryTreePaths().binaryTreePaths(root);
        System.out.println(result);
    }
}