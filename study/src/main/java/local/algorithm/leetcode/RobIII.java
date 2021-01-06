package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobIII {

    public int rob(TreeNode root) {
        return rec(root, new HashMap<>());
    }

    private int rec(TreeNode root, Map<TreeNode, Integer> calculated) {
        if (root == null) {
            return 0;
        }
        if (calculated.containsKey(root)) {
            return calculated.get(root);
        }
        int useRoot = root.val;
        if (root.left != null) {
            useRoot += rec(root.left.left, calculated) + rec(root.left.right, calculated);
        }
        if (root.right != null) {
            useRoot += rec(root.right.left, calculated) + rec(root.right.right, calculated);
        }
        int result = Math.max(useRoot, rec(root.left, calculated) + rec(root.right, calculated));
        calculated.put(root, result);
        return result;
    }
}
