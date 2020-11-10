package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 21:16
 */
public class LongestUnivaluePathTest {

    @Test
    public void testLongestUnivaluePath1() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7, null, null),
                                new TreeNode(2, null, null))
                        , null),
                new TreeNode(5,
                        new TreeNode(13, null, null),
                        new TreeNode(5,
                                null,
                                new TreeNode(1, null, null))));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testLongestUnivaluePath2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(5,
                        new TreeNode(5,
                                new TreeNode(7, null, null),
                                new TreeNode(5, null, null))
                        , null),
                new TreeNode(5,
                        new TreeNode(13, null, null),
                        new TreeNode(5,
                                null,
                                new TreeNode(1, null, null))));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testLongestUnivaluePath3() {
        TreeNode root = new TreeNode(5, null, null);
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testLongestUnivaluePath4() {
        TreeNode root = new TreeNode(1,
                new TreeNode(4,
                        new TreeNode(4, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(5, null,
                                null)));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testLongestUnivaluePath5() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(1, null, null),
                        new TreeNode(1, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(5, null,
                                null)));
        int result = new LongestUnivaluePath().longestUnivaluePath(root);
        Assert.assertEquals(result, 2);
    }

}