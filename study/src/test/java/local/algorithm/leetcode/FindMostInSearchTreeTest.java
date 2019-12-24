package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class FindMostInSearchTreeTest {

    @Test
    public void testFindMode1() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(2, null, null),
                        null));

        FindMostInSearchTree find = new FindMostInSearchTree();
        find.findMode(root);
        Assert.assertEquals(find.result, Lists.newArrayList(2));
    }

    @Test
    public void testFindMode2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(1, null, null),
                new TreeNode(2,
                        new TreeNode(2, null, null),
                        null));

        FindMostInSearchTree find = new FindMostInSearchTree();
        find.findMode(root);
        Assert.assertEquals(find.result, Lists.newArrayList(1, 2));
    }
}