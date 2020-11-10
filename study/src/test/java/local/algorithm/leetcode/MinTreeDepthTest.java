package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class MinTreeDepthTest {

    @Test
    public void testMinDepth1() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(2, null, null))
                        , null),
                new TreeNode(8,
                        new TreeNode(13, null, null),
                        new TreeNode(4,
                                null,
                                new TreeNode(1, null, null))));

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testMinDepth2() {
        TreeNode root = new TreeNode(5, null, null);

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testMinDepth3() {
        TreeNode root = new TreeNode(5,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));

        int result = new MinTreeDepth().minDepth(root);
        Assert.assertEquals(result, 2);

        System.out.println(0b11111111111111111111111111111111);
        System.out.println(0b10000000000000000000000000000001);
        System.out.println(Integer.MIN_VALUE);
        //2147483645
        //2147483645
    }
}