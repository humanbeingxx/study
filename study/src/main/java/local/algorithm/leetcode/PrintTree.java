package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<String>> print = new ArrayList<>();
        int height = height(root);
        int weight = (int) (Math.pow(2, height) - 1);
        for (int i = 0; i < height; i++) {
            List<String> printLevel = new ArrayList<>(weight);
            for (int j = 0; j < weight; j++) {
                printLevel.add("");
            }
            print.add(printLevel);
        }
        fill(root, print, 1, 0, weight - 1);
        return print;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private void fill(TreeNode root, List<List<String>> print, int level, int start, int end) {
        if (root ==null) {
            return;
        }
        List<String> printLevel = print.get(level - 1);
        int pos = (start + end) / 2;
        printLevel.set(pos, Integer.toString(root.val));
        fill(root.left, print, level + 1, start, pos - 1);
        fill(root.right, print, level + 1, pos + 1, end);
    }
}
