package local.algorithm.leetcode;

import java.util.*;

public class SortByGroupsRespectingDependencies {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> itemsByGroup = groupItems(group);
        Map<Integer, Set<Integer>> itemRelation = createRelation(beforeItems);
        int[] inDegrees = calcInDegrees(beforeItems);

        int[] sorted = new int[n];
        int index = 0;
        for (int currentGroup = 0; currentGroup < n; currentGroup++) {
            Set<Integer> items = itemsByGroup.get(currentGroup);
            if (items == null || items.isEmpty()) {
                continue;
            }
            List<Integer> partSort = sortByDegree(currentGroup, items, inDegrees, group, itemsByGroup, itemRelation);
            if (partSort == null) {
                return new int[0];
            } else {
                for (Integer item : partSort) {
                    sorted[index++] = item;
                }
            }
        }
        if (itemsByGroup.containsKey(-1)) {
            List<Integer> partSort = sortByDegree(-1, itemsByGroup.get(-1), inDegrees, group, itemsByGroup, itemRelation);
            if (partSort == null) {
                return new int[0];
            } else {
                for (Integer item : partSort) {
                    sorted[index++] = item;
                }
            }
        }
        return sorted;
    }

    private List<Integer> sortByDegree(int currentGroup, Set<Integer> items, int[] inDegrees, int[] group,
                                       Map<Integer, Set<Integer>> itemsByGroup,
                                       Map<Integer, Set<Integer>> itemRelation) {
        List<Integer> sorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer item : items) {
            if (inDegrees[item] == 0) {
                queue.add(item);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                items.remove(poll);
                sorted.add(poll);
                if (!itemRelation.containsKey(poll)) {
                    continue;
                }
                for (Integer after : itemRelation.get(poll)) {
                    inDegrees[after]--;
                    if ((group[after] == -1 || group[after] == currentGroup) && inDegrees[after] == 0) {
                        queue.add(after);
                        itemsByGroup.get(group[after]).remove(after);
                        group[after] = currentGroup;
                    }
                }
            }
        }
        if (!items.isEmpty()) {
            return null;
        }
        return sorted;
    }

    private Map<Integer, Set<Integer>> groupItems(int[] group) {
        Map<Integer, Set<Integer>> itemsByGroup = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            itemsByGroup.putIfAbsent(group[i], new HashSet<>());
            itemsByGroup.get(group[i]).add(i);
        }
        return itemsByGroup;
    }

    private Map<Integer, Set<Integer>> createRelation(List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> relations = new HashMap<>();
        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer before : beforeItems.get(i)) {
                relations.putIfAbsent(before, new HashSet<>());
                relations.get(before).add(i);
            }
        }
        return relations;
    }

    private int[] calcInDegrees(List<List<Integer>> beforeItems) {
        int[] inDegrees = new int[beforeItems.size()];
        for (int i = 0; i < beforeItems.size(); i++) {
            inDegrees[i] = beforeItems.get(i).size();
        }
        return inDegrees;
    }
}
