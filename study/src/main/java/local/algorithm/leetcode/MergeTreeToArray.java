package local.algorithm.leetcode;

import local.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/8 20:16
 */
public class MergeTreeToArray {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        collect(root1, list1);
        collect(root2, list2);

        return merge(list1, list2);
    }

    private void collect(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        collect(node.left, list);
        list.add(node.val);
        collect(node.right, list);
    }


    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int index1 = 0, index2 = 0;
        List<Integer> result = new ArrayList<>(list1.size() + list2.size());
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1).equals(list2.get(index2))) {
                result.add(list1.get(index1++));
                result.add(list2.get(index2++));
            } else if (list1.get(index1) > list2.get(index2)) {
                result.add(list2.get(index2++));
            } else {
                result.add(list1.get(index1++));
            }
        }
        while (index1 < list1.size()) {
            result.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            result.add(list2.get(index2++));
        }
        return result;
    }

}
