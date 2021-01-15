package local.algorithm.leetcode;

import java.util.*;

public class RemoveStones {

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = buildGraph(stones);
        int[] union = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            union[i] = i;
        }
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int stoneA = entry.getKey();
            for (int neighbor : entry.getValue()) {
                merge(union, stoneA, neighbor);
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            roots.add(findRoot(union, i));
        }
        return stones.length - roots.size();
    }

    private int findRoot(int[] union, int node) {
        int find = node;
        while (union[find] != find) {
            find = union[find];
        }
        union[node] = find;
        return find;
    }

    private void merge(int[] union, int a, int b) {
        int rootA = findRoot(union, a);
        int rootB = findRoot(union, b);
        union[rootA] = rootB;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] stones) {
        Map<Integer, List<Integer>> rowStones = new HashMap<>();
        Map<Integer, List<Integer>> columnStones = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            rowStones.putIfAbsent(stone[0], new ArrayList<>());
            rowStones.get(stone[0]).add(i);
            columnStones.putIfAbsent(stone[1], new ArrayList<>());
            columnStones.get(stone[1]).add(i);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            List<Integer> neighbors = new ArrayList<>();
            neighbors.addAll(rowStones.get(stone[0]));
            neighbors.addAll(columnStones.get(stone[1]));
            graph.put(i, neighbors);
        }
        return graph;
    }

}
