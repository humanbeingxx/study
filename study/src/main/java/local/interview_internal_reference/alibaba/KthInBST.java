package local.interview_internal_reference.alibaba;

import local.interview_internal_reference.TreeNode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/6 16:52
 */
public class KthInBST {

    private int pos = 0;

    public int kth(TreeNode root, int k) {
        Integer kth = rec(root, k);
        return kth == null ? -1 : kth;
    }

    private Integer rec(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Integer kth = null;
        if (root.getLeft() != null) {
            kth = rec(root.getLeft(), k);
        }
        if (kth != null) {
            return kth;
        }
        pos++;
        if (pos == k) {
            return root.getVal();
        }
        return rec(root.getRight(), k);
    }
}
