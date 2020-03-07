package local.algorithm.leetcode;

import local.algorithm.leetcode.BinaryTreeHasPathSum.TreeNode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class DistanceKInTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> graph = toGraph(root);
        if (graph.isEmpty()) {
            return new ArrayList<>();
        }
        return bfsK(graph, target.val, K);
    }

    private List<Integer> bfsK(Map<Integer, List<Integer>> graph, int start, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> saw = new HashSet<>();
        saw.add(start);
        int level = 0;
        while (!queue.isEmpty() && level != k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (Integer next : graph.get(poll)) {
                    if (!saw.contains(next)) {
                        queue.add(next);
                        saw.add(next);
                    }
                }
            }
            level++;
        }
        return new ArrayList<>(queue);
    }

    Map<Integer, List<Integer>> toGraph(TreeNode root) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        collectEdges(graph, root);
        return graph;
    }

    private void collectEdges(Map<Integer, List<Integer>> graph, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            graph.putIfAbsent(node.val, new ArrayList<>());
            graph.get(node.val).add(node.left.val);
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.left.val).add(node.val);
            collectEdges(graph, node.left);
        }
        if (node.right != null) {
            graph.putIfAbsent(node.val, new ArrayList<>());
            graph.get(node.val).add(node.right.val);
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.right.val).add(node.val);
            collectEdges(graph, node.right);
        }
    }
}
