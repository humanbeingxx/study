package local.algorithm.leetcode;

import java.util.Stack;

public class CheckValidAfterSubstitutions {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'c') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false;
                }
                stack.pop();
                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
