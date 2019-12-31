package local.algorithm.leetcode;

import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class RemoveNeighbourDuplicates {

    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
            } else {
                Character peek = stack.peek();
                if (peek == S.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
