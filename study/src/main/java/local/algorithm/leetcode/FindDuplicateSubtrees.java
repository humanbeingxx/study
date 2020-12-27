package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees {

    static class PathNode {
        TreeNode node;
        String path;

        public PathNode(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(path, ((PathNode) o).path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(path);
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<PathNode, Integer> pathCount = new HashMap<>();
        rec(root, pathCount);
        return pathCount.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey().node)
                .collect(Collectors.toList());
    }

    private String rec(TreeNode root, Map<PathNode, Integer> pathCount) {
        if (root == null) {
            return "x";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String left = rec(root.left, pathCount);
        String right = rec(root.right, pathCount);
        stringBuilder.append(left).append(",").append(right).append(",").append(root.val);
        String path = stringBuilder.toString();
        PathNode pathNode = new PathNode(root, path);
        pathCount.put(pathNode, pathCount.getOrDefault(pathNode, 0) + 1);
        return path;
    }
}
