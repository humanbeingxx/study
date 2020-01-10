package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class IterInOrderTraversalTest {

    @Test
    public void testInorderTraversal() {

        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3)
                        , null));
        List<Integer> result = new IterInOrderTraversal().inorderTraversal(root);
        assertEquals(result, Lists.newArrayList(1, 3, 2));
    }
}