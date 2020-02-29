package local.algorithm.leetcode;

import java.util.Stack;

public class MinRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
                if (c == '(') {
                    left++;
                }
            } else if (left > 0) {
                stack.push(c);
                left--;
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                if (left == 0) {
                    sb.append(c);
                } else {
                    left--;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
