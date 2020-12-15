package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class FindSecondMinimumValueInTreeTest {

    @Test
    public void testFindSecondMinimumValue1() {
        TreeNode root = new TreeNode(2,
                new TreeNode(2, null, null),
                new TreeNode(5,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null)));
        int result = new FindSecondMinimumValueInTree().findSecondMinimumValue(root);
        assertEquals(result, 5);
    }

    @Test
    public void testFindSecondMinimumValue2() {
        TreeNode root = new TreeNode(5,
                new TreeNode(5, null, null),
                new TreeNode(5, null, null));
        int result = new FindSecondMinimumValueInTree().findSecondMinimumValue(root);
        assertEquals(result, -1);
    }

    @Test
    public void testFindSecondMinimumValue3() {
        TreeNode root = new TreeNode(5, null, null);
        int result = new FindSecondMinimumValueInTree().findSecondMinimumValue(root);
        assertEquals(result, -1);
    }

    @Test
    public void testFindSecondMinimumValue4() {
        TreeNode root = null;
        int result = new FindSecondMinimumValueInTree().findSecondMinimumValue(root);
        assertEquals(result, -1);
    }
}