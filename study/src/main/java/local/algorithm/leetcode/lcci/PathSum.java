package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 22:00
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = dfsInPath(root, sum);
        count += dfs(root.left, sum);
        count += dfs(root.right, sum);
        return count;
    }

    private int dfsInPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        count += dfsInPath(root.left, sum - root.val);
        count += dfsInPath(root.right, sum - root.val);
        return count;
    }
}
