package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        preCal(edges, edgeMap, inDegrees);
        while (inDegrees.size() > 2) {
            List<Integer> needRemove = new ArrayList<>();
            for (Map.Entry<Integer, Integer> degree : inDegrees.entrySet()) {
                if (degree.getValue() == 1) {
                    needRemove.add(degree.getKey());
                }
            }
            for (Integer i : needRemove) {
                inDegrees.remove(i);
                for (Integer next : edgeMap.get(i)) {
                    if (inDegrees.containsKey(next)) {
                        inDegrees.put(next, inDegrees.get(next) - 1);
                    }
                }
            }
        }
        result.addAll(inDegrees.keySet());
        return result;
    }

    private void preCal(int[][] edges, Map<Integer, List<Integer>> edgeMap, Map<Integer, Integer> inDegrees) {
        for (int[] edge : edges) {
            inDegrees.put(edge[0], inDegrees.getOrDefault(edge[0], 0) + 1);
            inDegrees.put(edge[1], inDegrees.getOrDefault(edge[1], 0) + 1);
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
    }
}
