package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N <= 0 || N % 2 == 0) {
            return result;
        }
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            result.add(root);
            return result;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> leftPossibles = allPossibleFBT(i);
            List<TreeNode> rightPossibles = allPossibleFBT(N - 1 - i);
            for (TreeNode left : leftPossibles) {
                for (TreeNode right : rightPossibles) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
