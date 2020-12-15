package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class Tree2str {

    private StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        rec(t);
        return sb.toString();
    }

    private void rec(TreeNode node) {
        if (node.left == null && node.right == null) {
            sb.append(node.val);
        } else if (node.left == null) {
            sb.append(node.val).append("()");
            sb.append("(");
            rec(node.right);
            sb.append(")");
        } else if (node.right == null) {
            sb.append(node.val);
            sb.append("(");
            rec(node.left);
            sb.append(")");
        } else {
            sb.append(node.val);
            sb.append("(");
            rec(node.left);
            sb.append(")");
            sb.append("(");
            rec(node.right);
            sb.append(")");
        }
    }
}
