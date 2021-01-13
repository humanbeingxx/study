package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRedundantConnection20210113 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] degrees = new int[edges.length + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        while (true) {
            boolean findCircle = true;
            for (int i = 1; i < degrees.length; i++) {
                if (degrees[i] == 1) {
                    findCircle = false;
                    degrees[i]--;
                    for (Integer next : graph.get(i)) {
                        degrees[next]--;
                    }
                    graph.remove(i);
                }
            }
            if (findCircle) {
                break;
            }
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (graph.containsKey(edge[0]) && graph.containsKey(edge[1])) {
                return edge;
            }
        }
        return null;
    }
}
