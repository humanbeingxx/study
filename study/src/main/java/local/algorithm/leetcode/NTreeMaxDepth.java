package local.algorithm.leetcode;

import local.algorithm.leetcode.NTreePreOrder.Node;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class NTreeMaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                int depth = maxDepth(child);
                if (depth > max) {
                    max = depth;
                }
            }
        }
        return max + 1;
    }
}
