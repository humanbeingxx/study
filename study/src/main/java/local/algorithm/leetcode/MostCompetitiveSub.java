package local.algorithm.leetcode;

import java.util.Stack;

public class MostCompetitiveSub {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < nums.length; index++) {
            if (stack.isEmpty()) {
                stack.push(nums[index]);
            } else if (nums.length - index + stack.size() == k) {
                stack.push(nums[index]);
            } else if (stack.size() != k || stack.peek() > nums[index]){
                while (!stack.isEmpty() && stack.peek() > nums[index] && nums.length - index + stack.size() - 1 >= k) {
                    stack.pop();
                }
                stack.push(nums[index]);
            }

        }
        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
