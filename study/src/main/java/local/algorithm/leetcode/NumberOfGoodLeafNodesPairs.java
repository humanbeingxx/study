package local.algorithm.leetcode;

import javafx.util.Pair;
import local.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodLeafNodesPairs {


    public int countPairs(TreeNode root, int distance) {
        return rec(root, distance).getValue();
    }

    private Pair<Map<Integer, Integer>, Integer> rec(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            Map<Integer, Integer> currLeaves = new HashMap<>();
            currLeaves.put(0, 1);
            return new Pair<>(currLeaves, 0);
        }
        Map<Integer, Integer> leftLeaves = new HashMap<>();
        Map<Integer, Integer> rightLeaves = new HashMap<>();
        int leftCount = 0, rightCount = 0;
        if (root.left != null) {
            Pair<Map<Integer, Integer>, Integer> leftPair = rec(root.left, distance);
            leftLeaves = leftPair.getKey();
            leftCount = leftPair.getValue();
        }
        if (root.right != null) {
            Pair<Map<Integer, Integer>, Integer> rightPair = rec(root.right, distance);
            rightLeaves = rightPair.getKey();
            rightCount = rightPair.getValue();
        }
        int currCount = 0;
        for (Map.Entry<Integer, Integer> leftEntry : leftLeaves.entrySet()) {
            for (Map.Entry<Integer, Integer> rightEntry : rightLeaves.entrySet()) {
                if (leftEntry.getKey() + rightEntry.getKey() <= distance - 2) {
                    currCount += leftEntry.getValue() * rightEntry.getValue();
                }
            }
        }
        Map<Integer, Integer> currLeaves = new HashMap<>();
        for (Map.Entry<Integer, Integer> leftEntry : leftLeaves.entrySet()) {
            int leftLevel = leftEntry.getKey() + 1;
            currLeaves.put(leftLevel, currLeaves.getOrDefault(leftLevel, 0) + leftEntry.getValue());
        }
        for (Map.Entry<Integer, Integer> rightEntry : rightLeaves.entrySet()) {
            int rightLevel = rightEntry.getKey() + 1;
            currLeaves.put(rightLevel, currLeaves.getOrDefault(rightLevel, 0) + rightEntry.getValue());
        }
        return new Pair<>(currLeaves, currCount + leftCount + rightCount);
    }
}
