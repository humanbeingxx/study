package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces2 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    merge(union, i, j);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(findRoot(union, i));
        }
        return roots.size();
    }

    private void merge(int[] union, int a, int b) {
        int rootA = findRoot(union, a);
        int rootB = findRoot(union, b);
        union[rootA] = rootB;
    }

    private int findRoot(int[] union, int target) {
        int node = target;
        while (union[node] != node) {
            node = union[node];
        }
        union[target] = node;
        return node;
    }
}
