package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostOrderTraversalTest {


    TreeNode root1 = new TreeNode(1,
            new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)),
            new TreeNode(3,
                    new TreeNode(6),
                    new TreeNode(7)));

    @Test
    public void testPostOrderTraversal() {
        List<Integer> result = new PostOrderTraversal().postOrderTraversal(root1);
        Assert.assertEquals(result, Lists.newArrayList(4, 5, 2, 6, 7, 3, 1));
    }

    @Test
    public void testPostOrderTraversal2() {
        List<Integer> result = new PostOrderTraversal().postOrderTraversal2(root1);
        Assert.assertEquals(result, Lists.newArrayList(4, 5, 2, 6, 7, 3, 1));
    }
}