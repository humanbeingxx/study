package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2020-02-19
 **/
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        int lenLeft = num.length() - k;
        if (lenLeft == 0) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        boolean headZero = true;
        for (char c : stack) {
            if (c == '0' && headZero) {
                continue;
            }
            headZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
