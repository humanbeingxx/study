package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> counts = new HashMap<>();
        countSum(root, counts);
        List<Integer> maxSums = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            Integer nodeVal = entry.getKey();
            Integer sum = entry.getValue();
            if (sum > maxSum) {
                maxSum = sum;
                maxSums.clear();
                maxSums.add(nodeVal);
            } else if (sum == maxSum) {
                maxSums.add(nodeVal);
            }
        }
        int[] result = new int[maxSums.size()];
        for (int i = 0; i < maxSums.size(); i++) {
            result[i] = maxSums.get(i);
        }
        return result;
    }

    private int countSum(TreeNode root, Map<Integer, Integer> counts) {
        if (root == null) {
            return 0;
        }
        int leftSum = countSum(root.left, counts);
        int rightSum = countSum(root.right, counts);
        int rootSum = root.val + leftSum + rightSum;
        counts.put(rootSum, counts.getOrDefault(rootSum, 0) + 1);
        return rootSum;
    }
}
