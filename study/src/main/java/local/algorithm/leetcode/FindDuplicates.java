package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/13 0:28
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int pos = Math.abs(num) - 1;
            if (nums[pos] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[pos] *= -1;
            }
        }
        return result;
    }

    public int findDuplicate(int[] nums) {
        int back = nums[0];
        int front = nums[nums[0]];
        while (back != front) {
            back = nums[back];
            front = nums[nums[front]];
        }

        int p1 = nums[0];
        int p2 = back;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
}
