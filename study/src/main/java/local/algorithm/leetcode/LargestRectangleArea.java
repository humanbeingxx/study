package local.algorithm.leetcode;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                while (!stack.isEmpty() && heights[stack.peek()] == height) {
                    stack.pop();
                }
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == height) {
                stack.pop();
            }
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, width * height);
        }
        return max;
    }
}
