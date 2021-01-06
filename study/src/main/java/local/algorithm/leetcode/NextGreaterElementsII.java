package local.algorithm.leetcode;

import java.util.Stack;

public class NextGreaterElementsII {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] dupNums = new int[nums.length * 2];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dupNums[i] = nums[i];
            dupNums[i + nums.length] = nums[i];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dupNums.length; i++) {
            int num = dupNums[i];
            while (!stack.isEmpty()) {
                Integer idx = stack.peek();
                int pre = dupNums[idx];
                if (num > pre) {
                    stack.pop();
                    result[idx] = dupNums[i];
                } else {
                    break;
                }
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
