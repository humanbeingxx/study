package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> onePath = new ArrayList<>();
        findRec(root, sum, onePath, result);
        return result;
    }

    private void findRec(TreeNode root, int sum, List<Integer> onePath, List<List<Integer>> result) {
        int nextSum = sum - root.val;
        onePath.add(root.val);
        if (root.left == null && root.right == null) {
            if (nextSum == 0) {
                result.add(new ArrayList<>(onePath));
            }
        }
        if (root.left != null) {
            findRec(root.left, nextSum, onePath, result);
        }
        if (root.right != null) {
            findRec(root.right, nextSum, onePath, result);
        }
        onePath.remove(onePath.size() - 1);
    }

}
