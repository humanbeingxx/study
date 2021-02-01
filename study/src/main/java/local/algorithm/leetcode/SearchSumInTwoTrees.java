package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class SearchSumInTwoTrees {

    public boolean search(TreeNode root1, TreeNode root2, int sum) {
        if (root1 == null && root2 == null) {
            return sum == 0;
        }
        if (root1 == null) {
            return root2.val == sum;
        }
        if (root2 == null) {
            return root1.val == sum;
        }
        int currSum = root1.val + root2.val;
        if (currSum == sum) {
            return true;
        } else if (currSum < sum) {
            return search(root1.right, root2, sum) || search(root1, root2.right, sum);
        } else {
            return search(root1.left, root2, sum) || search(root1, root2.left, sum);
        }
    }
}
