package local.algorithm.leetcode;

import java.util.*;

public class MinTimeForApples {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> tree = buildTree(edges);
        return 2 * rec(0, tree, new boolean[n], hasApple);
    }

    private Map<Integer, List<Integer>> buildTree(int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.putIfAbsent(edge[0], new ArrayList<>());
            tree.putIfAbsent(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    private int rec(int node, Map<Integer, List<Integer>> tree, boolean[] nodeInPath, List<Boolean> hasApple) {
        List<Integer> children = tree.get(node);
        int sumOfLength = 0;
        nodeInPath[node] = true;
        for (Integer child : children) {
            if (!nodeInPath[child]) {
                sumOfLength += rec(child, tree, nodeInPath, hasApple);
            }
        }
        if (sumOfLength == 0 && !hasApple.get(node)) {
            return 0;
        }
        if (node == 0) {
            return sumOfLength;
        } else {
            return sumOfLength + 1;
        }
    }

}
