package local.algorithm.leetcode;

import local.algorithm.leetcode.NTreePreOrder.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:27
 */
public class NTreePostOrder {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        rec(root, result);
        return result;
    }

    private void rec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                rec(child, result);
            }
        }
        result.add(node.val);
    }
}
