package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class HitBricks {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] *= -1;
        }
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet = buildUnionSet(grid);
        Map<Pair<Integer, Integer>, Integer> countAfterAllHits = countSplit(unionSet);
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            if (grid[hit[0]][hit[1]] == 0) {
                continue;
            }
            addNode(unionSet, hit[0], hit[1]);
            Map<Pair<Integer, Integer>, Integer> countAfterAdd = countSplit(unionSet);
            result[i] = diff(countAfterAllHits, countAfterAdd);
            countAfterAllHits = countAfterAdd;
        }
        return result;
    }

    private int diff(Map<Pair<Integer, Integer>, Integer> countAfterAllHits, Map<Pair<Integer, Integer>, Integer> countAfterAdd) {
        int countTopBefore = 0, countTopAfter = 0;
        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : countAfterAllHits.entrySet()) {
            if (entry.getKey().getKey() == 0) {
                countTopBefore += entry.getValue();
            }
        }
        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : countAfterAdd.entrySet()) {
            if (entry.getKey().getKey() == 0) {
                countTopAfter += entry.getValue();
            }
        }
        return countTopAfter == countTopBefore ? 0 : countTopAfter - countTopBefore - 1;
    }

    private Map<Pair<Integer, Integer>, Integer> countSplit(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet) {
        Map<Pair<Integer, Integer>, Integer> counts = new HashMap<>();
        for (Pair<Integer, Integer> node : unionSet.keySet()) {
            Pair<Integer, Integer> root = findRoot(unionSet, node);
            counts.put(root, counts.getOrDefault(root, 0) + 1);
        }
        return counts;
    }

    private void addNode(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet, int i, int j) {
        Pair<Integer, Integer> upRoot = findRoot(unionSet, new Pair<>(i - 1, j));
        Pair<Integer, Integer> leftRoot = findRoot(unionSet, new Pair<>(i, j - 1));
        Pair<Integer, Integer> rightRoot = findRoot(unionSet, new Pair<>(i, j + 1));
        Pair<Integer, Integer> downRoot = findRoot(unionSet, new Pair<>(i + 1, j));
        Pair<Integer, Integer> node = new Pair<>(i, j);
        Pair<Integer, Integer> candidate = findCandidate(node, upRoot, leftRoot, rightRoot, downRoot);
        if (candidate == null) {
            unionSet.put(node, node);
        } else {
            unionSet.put(node, candidate);
            updateNode(unionSet, upRoot, candidate);
            updateNode(unionSet, leftRoot, candidate);
            updateNode(unionSet, rightRoot, candidate);
            updateNode(unionSet, downRoot, candidate);
        }
    }

    private Pair<Integer, Integer> findCandidate(Pair<Integer, Integer> node, Pair<Integer, Integer> upRoot,
                                                 Pair<Integer, Integer> leftRoot,
                                                 Pair<Integer, Integer> rightRoot,
                                                 Pair<Integer, Integer> downRoot) {
        if (node.getKey() == 0) {
            return node;
        }
        Pair<Integer, Integer> notNull = null;
        if (upRoot != null) {
            if (upRoot.getKey() == 0) {
                return upRoot;
            }
            notNull = upRoot;
        }
        if (leftRoot != null) {
            if (leftRoot.getKey() == 0) {
                return leftRoot;
            }
            notNull = leftRoot;
        }
        if (rightRoot != null) {
            if (rightRoot.getKey() == 0) {
                return rightRoot;
            }
            notNull = rightRoot;
        }
        if (downRoot != null) {
            if (downRoot.getKey() == 0) {
                return downRoot;
            }
            notNull = downRoot;
        }
        return notNull;
    }

    private void updateNode(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet,
                            Pair<Integer, Integer> node,
                            Pair<Integer, Integer> update) {
        if (node != null && update != null) {
            unionSet.put(node, update);
        }
    }

    private Pair<Integer, Integer> findRoot(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet,
                                            Pair<Integer, Integer> node) {
        if (!unionSet.containsKey(node)) {
            return null;
        }
        Pair<Integer, Integer> find = node;
        while (!unionSet.get(find).equals(find)) {
            find = unionSet.get(find);
        }
        unionSet.put(node, find);
        return find;
    }

    private Map<Pair<Integer, Integer>, Pair<Integer, Integer>> buildUnionSet(int[][] grid) {
        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> unionSet = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    addNode(unionSet, i, j);
                }
            }
        }
        return unionSet;
    }
}
