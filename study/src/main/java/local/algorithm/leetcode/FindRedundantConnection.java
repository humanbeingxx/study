package local.algorithm.leetcode;

import java.util.*;

public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        Set<Integer> points = new HashSet<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[0] > n) {
                n = edge[0];
            }
            if (edge[1] > n) {
                n = edge[1];
            }
            points.add(edge[0]);
            points.add(edge[1]);
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[1]).add(edge[0]);
        }
        int[] degrees = new int[n + 1];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        while (true) {
            boolean findCircle = true;
            for (int i = 1; i <= n; i++) {
                if (degrees[i] == 1) {
                    findCircle = false;
                    points.remove(i);
                    degrees[i]--;
                    for (Integer next : edgeMap.get(i)) {
                        degrees[next]--;
                    }
                }
            }
            if (findCircle || points.size() == 0) {
                break;
            }
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            if (points.contains(edges[i][0]) && points.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }
}
