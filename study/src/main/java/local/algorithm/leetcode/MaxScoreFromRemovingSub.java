package local.algorithm.leetcode;

import java.util.Stack;

public class MaxScoreFromRemovingSub {

    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        char first = x >= y ? 'a' : 'b', second = x >= y ? 'b' : 'a';
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == second && !stack.isEmpty() && stack.peek() == first) {
                stack.pop();
                max += Math.max(x, y);
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return max;
        }
        Stack<Character> stackOver = new Stack<>();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (!stackOver.isEmpty() && pop == second && stackOver.peek() == first) {
                max += Math.min(x, y);
                stackOver.pop();
            } else {
                stackOver.push(pop);
            }
        }
        return max;
    }
}
