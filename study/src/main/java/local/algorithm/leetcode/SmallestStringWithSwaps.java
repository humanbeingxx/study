package local.algorithm.leetcode;

import java.util.*;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s.length() <= 1 || pairs.size() == 0) {
            return s;
        }
        int[] union = new int[s.length()];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        for (List<Integer> pair : pairs) {
            merge(union, pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < union.length; i++) {
            int root = findRoot(union, i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }
        char[] chars = new char[s.length()];
        for (List<Integer> group : groups.values()) {
            List<Integer> sortList = new ArrayList<>(group);
            sortList.sort(Comparator.comparingInt(s::charAt));
            for (int i = 0; i < group.size(); i++) {
                chars[group.get(i)] = s.charAt(sortList.get(i));
            }
        }
        return new String(chars);
    }

    private void merge(int[] union, int a, int b) {
        int rootA = findRoot(union, a);
        int rootB = findRoot(union, b);
        union[rootA] = rootB;
    }

    private int findRoot(int[] union, int i) {
        int find = i;
        while (union[find] != find) {
            find = union[find];
        }
        union[i] = find;
        return find;
    }
}
