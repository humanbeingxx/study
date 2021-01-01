package local.algorithm.leetcode;

import java.util.*;

public class NumberOfSubTreeNodesWithSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] result = new int[n];
        Map<Integer, List<Integer>> edgeMap = createMap(edges);
        int[][] counts = new int[n][];
        for (int i = 0; i < n; i++) {
            countWithSub(i, edgeMap, counts, labels);
        }
        for (int i = 0; i < n; i++) {
            char c = labels.charAt(i);
            result[i] = counts[i][c - 'a'];
        }
        return result;
    }

    private void countWithSub(int start, Map<Integer, List<Integer>> edgeMap, int[][] counts, String labels) {
        if (counts[start] != null) {
            return;
        }
        counts[start] = new int[26];
        counts[start][labels.charAt(start) - 'a'] = 1;
        if (edgeMap.containsKey(start)) {
            for (Integer next : edgeMap.get(start)) {
                countWithSub(next, edgeMap, counts, labels);
                mergeInto(counts[start], counts[next]);
            }
        }
    }

    private void mergeInto(int[] target, int[] source) {
        for (int i = 0; i < 26; i++) {
            target[i] += source[i];
        }
    }

    private Map<Integer, List<Integer>> createMap(int[][] edges) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        Map<Integer, List<Integer>> realMap = new HashMap<>();
        for (int[] edge : edges) {
            map1.putIfAbsent(edge[0], new ArrayList<>());
            map1.get(edge[0]).add(edge[1]);
            map2.putIfAbsent(edge[1], new ArrayList<>());
            map2.get(edge[1]).add(edge[0]);
        }
        int root = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        Set<Integer> inTree = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                inTree.add(poll);
                realMap.putIfAbsent(poll, new ArrayList<>());
                List<Integer> nexts = realMap.get(poll);

                if (map1.containsKey(poll)) {
                    for (Integer node : map1.get(poll)) {
                        if (!inTree.contains(node)) {
                            nexts.add(node);
                        }
                    }
                }
                if (map2.containsKey(poll)) {
                    for (Integer node : map2.get(poll)) {
                        if (!inTree.contains(node)) {
                            nexts.add(node);
                        }
                    }
                }
                for (Integer next : realMap.get(poll)) {
                    if (!inTree.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return realMap;
    }
}
