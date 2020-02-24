package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-24
 **/
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(root, 0, sum, temp, result);
        return result;
    }

    private void rec(TreeNode node, int curSum, int targetSum, List<Integer> temp, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        temp.add(node.val);
        if (curSum == targetSum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(temp));
        }
        if (node.left != null) {
            rec(node.left, curSum, targetSum, temp, result);
        }
        if (node.right != null) {
            rec(node.right, curSum, targetSum, temp, result);
        }
        temp.remove(temp.size() - 1);
    }


}
