package local.algorithm.leetcode;

import local.algorithm.leetcode.NTreePreOrder.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-21
 **/
public class NTreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                List<Node> children = node.children;
                if (children != null) {
                    queue.addAll(children);
                }
            }
            result.add(new ArrayList<>(temp));
            temp.clear();
        }
        return result;
    }
}
