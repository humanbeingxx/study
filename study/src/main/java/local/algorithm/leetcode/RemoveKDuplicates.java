package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveKDuplicates {

    public String removeDuplicates(String s, int k) {
        Stack<Map.Entry<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Map.Entry<Character, Integer> peek = stack.peek();
                if (peek.getKey() == c) {
                    peek.setValue(peek.getValue() + 1);
                    if (peek.getValue() == k) {
                        stack.pop();
                    }
                } else {
                    stack.push(new HashMap.SimpleEntry<>(c, 1));
                }
            } else {
                stack.push(new HashMap.SimpleEntry<>(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : stack) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}