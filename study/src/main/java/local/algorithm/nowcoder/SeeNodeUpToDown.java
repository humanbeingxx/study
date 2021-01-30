package local.algorithm.nowcoder;

import local.algorithm.leetcode.common.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class SeeNodeUpToDown {

    public List<TreeNode> canSee(TreeNode root) {
        List<Pair<TreeNode, Integer>> result = new ArrayList<>();
        Set<Integer> sawColumn = new HashSet<>();
        seeRec(root, 0, sawColumn, result);
        return result.stream().
                sorted(Comparator.comparing(Pair::getRight))
                .map(Pair::getLeft)
                .collect(Collectors.toList());
    }

    private void seeRec(TreeNode root, int currentColumn, Set<Integer> sawColumn, List<Pair<TreeNode, Integer>> result) {
        if (root == null) {
            return;
        }
        if (!sawColumn.contains(currentColumn)) {
            result.add(Pair.of(root, currentColumn));
            sawColumn.add(currentColumn);
        }
        seeRec(root.left, currentColumn - 1, sawColumn, result);
        seeRec(root.right, currentColumn + 1, sawColumn, result);
    }
}
