package local.algorithm.leetcode;

import java.util.*;

public class MinReorder {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = buildGraph(connections);
        boolean[] reached = new boolean[n];
        return reorderRec(0, graph, reached);
    }

    private int reorderRec(int node, Map<Integer, List<Integer>> graph, boolean[] reached) {
        if (reached[node] || !graph.containsKey(node)) {
            return 0;
        }
        int count = 0;
        reached[node] = true;
        List<Integer> nexts = graph.get(node);
        for (Integer next : nexts) {
            if (reached[Math.abs(next)]) {
                continue;
            }
            if (next < 0) {
                count++;
                next = -next;
            }
            count += reorderRec(next, graph, reached);
        }
        return count;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            if (connection[0] == 0) {
                graph.putIfAbsent(0, new ArrayList<>());
                graph.get(0).add(-connection[1]);
            } else if (connection[1] == 0) {
                graph.putIfAbsent(0, new ArrayList<>());
                graph.get(0).add(connection[0]);
            } else {
                graph.putIfAbsent(connection[0], new ArrayList<>());
                graph.putIfAbsent(connection[1], new ArrayList<>());
                graph.get(connection[0]).add(-connection[1]);
                graph.get(connection[1]).add(connection[0]);
            }
        }
        return graph;
    }
}
