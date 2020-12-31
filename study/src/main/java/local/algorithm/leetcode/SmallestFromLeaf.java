package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

public class SmallestFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        findRec(root, new StringBuilder(), smallest);
        return smallest.toString();
    }

    private void findRec(TreeNode root, StringBuilder stringBuilder, StringBuilder smallest) {
        stringBuilder.insert(0, (char) (root.val + 'a'));

        if (root.left == null && root.right == null) {
            if (smallest.length() == 0) {
                smallest.append(stringBuilder);
            } else {
                if (smaller(stringBuilder, smallest)) {
                    smallest.setLength(0);
                    smallest.append(stringBuilder);
                }
            }
        }
        if (root.left != null) {
            findRec(root.left, stringBuilder, smallest);
        }
        if (root.right != null) {
            findRec(root.right, stringBuilder, smallest);
        }
        stringBuilder.deleteCharAt(0);
    }

    private boolean smaller(StringBuilder a, StringBuilder b) {
        int index0 = 0, index1 = 0;
        while (index0 < a.length() && index1 < b.length()) {
            if (a.charAt(index0) == b.charAt(index1)) {
                index0++;
                index1++;
            } else {
                return a.charAt(index0) < b.charAt(index1);
            }
        }
        return index1 == a.length();
    }

}
