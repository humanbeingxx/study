package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> preLevel = new ArrayList<>();
        List<TreeNode> currLevel = new ArrayList<>();
        List<TreeNode> temp = null;
        List<Double> result = new ArrayList<>();

        preLevel.add(root);
        while (!preLevel.isEmpty()) {
            int sum = 0;
            for (TreeNode node : preLevel) {
                if (node.left != null) {
                    currLevel.add(node.left);
                }
                if (node.right != null) {
                    currLevel.add(node.right);
                }
                sum += node.val;
            }
            double avg = ((double) sum) / preLevel.size();
            result.add(avg);
            temp = preLevel;
            preLevel = currLevel;
            currLevel = temp;
            currLevel.clear();
        }
        return result;
    }
}
