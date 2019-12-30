package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class BinaryTreePaths {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
        }
        if (root.left != null) {
            rec(root.left, root.val + "");
        }
        if (root.right != null) {
            rec(root.right, root.val + "");
        }
        return paths;
    }

    private void rec(TreeNode node, String currPath) {
        if (node.left == null && node.right == null) {
            paths.add(currPath + "->" + node.val);
        } else {
            if (node.left != null) {
                rec(node.left, currPath + "->" + node.val);
            }
            if (node.right != null) {
                rec(node.right, currPath + "->" + node.val);
            }
        }
    }
}
