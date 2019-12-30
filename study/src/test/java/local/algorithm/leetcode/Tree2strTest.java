package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class Tree2strTest {

    @Test
    public void testTree2str1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null),
                new TreeNode(3, null, null));
        String result = new Tree2str().tree2str(root);
        assertEquals(result, "1(2(4))(3)");
    }

    @Test
    public void testTree2str2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4, null, null)),
                new TreeNode(3, null, null));
        String result = new Tree2str().tree2str(root);
        assertEquals(result, "1(2()(4))(3)");
    }
}