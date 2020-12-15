package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class SortedArrayToBSTTest {

    @Test
    public void testSortedArrayToBST() {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root);

        root = new SortedArrayToBST().sortedArrayToBST(new int[]{1});
        System.out.println(root);

        root = new SortedArrayToBST().sortedArrayToBST(new int[]{});
        System.out.println(root);
    }
}