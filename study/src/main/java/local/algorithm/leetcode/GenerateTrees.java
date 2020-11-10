package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-11
 **/
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<TreeNode>[][][] checked = new ArrayList[n + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            List<TreeNode> nodes = rec(1, n, i, checked);
            treeNodes.addAll(nodes);
        }
        return treeNodes;
    }

    private List<TreeNode> rec(int from, int to, int root, List<TreeNode>[][][] checked) {
        List<TreeNode> nodes = new ArrayList<>();

        if (from > to) {
            return nodes;
        }
        if (from == to) {
            nodes.add(new TreeNode(from));
            checked[from][to][from] = nodes;
            return nodes;
        }

        if (from == root) {
            for (int i = root + 1; i <= to; i++) {
                List<TreeNode> rightNodes = checked[root + 1][to][i];
                if (rightNodes == null || rightNodes.isEmpty()) {
                    rightNodes = rec(root + 1, to, i, checked);
                }
                for (TreeNode rightNode : rightNodes) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.right = rightNode;
                    nodes.add(rootNode);
                }
            }
        } else if (root == to) {
            for (int i = from; i < root; i++) {
                List<TreeNode> leftNodes = checked[from][root - 1][i];
                if (leftNodes == null || leftNodes.isEmpty()) {
                    leftNodes = rec(from, root - 1, i, checked);
                }
                for (TreeNode leftNode : leftNodes) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftNode;
                    nodes.add(rootNode);
                }
            }
        } else {
            for (int i = from; i < root; i++) {
                List<TreeNode> leftNodes = checked[from][root - 1][i];
                if (leftNodes == null || leftNodes.isEmpty()) {
                    leftNodes = rec(from, root - 1, i, checked);
                }
                for (int j = root + 1; j <= to; j++) {
                    List<TreeNode> rightNodes = checked[root + 1][to][j];
                    if (rightNodes == null || rightNodes.isEmpty()) {
                        rightNodes = rec(root + 1, to, j, checked);
                    }
                    for (TreeNode leftNode : leftNodes) {
                        for (TreeNode rightNode : rightNodes) {
                            TreeNode rootNode = new TreeNode(root);
                            rootNode.left = leftNode;
                            rootNode.right = rightNode;
                            nodes.add(rootNode);
                        }
                    }
                }
            }
        }


        checked[from][to][root] = nodes;

        return nodes;
    }
}
