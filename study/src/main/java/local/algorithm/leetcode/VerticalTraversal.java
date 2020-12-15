package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> positions = new ArrayList<>();
        rec(root, 0, 0, positions);
        TreeMap<Integer, List<int[]>> groupByX = new TreeMap<>();
        for (int[] position : positions) {
            groupByX.putIfAbsent(position[0], new ArrayList<>());
            groupByX.get(position[0]).add(position);
        }
        List<List<int[]>> groups = new ArrayList<>(groupByX.values());
        groups.forEach(group -> group.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            } else {
                return o1[1] - o2[1];
            }
        }));
        return groups.stream().map(e -> {
            List<Integer> vals = new ArrayList<>();
            for (int[] ints : e) {
                vals.add(ints[2]);
            }
            return vals;
        }).collect(Collectors.toList());
    }

    private void rec(TreeNode root, int x, int y, List<int[]> positions) {
        if (root == null) {
            return;
        }
        positions.add(new int[]{x, y, root.val});
        rec(root.left, x - 1, y - 1, positions);
        rec(root.right, x + 1, y - 1, positions);
    }
}
